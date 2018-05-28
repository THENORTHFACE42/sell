package com.lizhenjie.service.impl;

import com.lizhenjie.converter.OrderMaster2OrderDTOConverter;
import com.lizhenjie.dao.OrderDetailDao;
import com.lizhenjie.dao.OrderMasterDao;
import com.lizhenjie.dataobject.OrderDetail;
import com.lizhenjie.dataobject.OrderMaster;
import com.lizhenjie.dataobject.ProductInfo;
import com.lizhenjie.dto.CartDTO;
import com.lizhenjie.dto.OrderDTO;
import com.lizhenjie.enums.OrderStatusEnum;
import com.lizhenjie.enums.PayStatusEnum;
import com.lizhenjie.enums.ResultEnum;
import com.lizhenjie.exception.SellException;
import com.lizhenjie.service.OrderService;
import com.lizhenjie.service.ProductService;
import com.lizhenjie.service.PushMessage;
import com.lizhenjie.service.WebSocket;
import com.lizhenjie.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 14:15 2018/5/6
 * @Modified By:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private PushMessage pushMessage;

    @Autowired
    private WebSocket webSocket;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId= KeyUtil.genUniqueKey();
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList=new ArrayList<>();

        //查询商品（数量，价格）
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if(productInfo==null){
                throw new SellException( ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算总价
            orderAmount= productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailDao.save(orderDetail);

//            CartDTO cartDTO=new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }
        //写入订单数据库（OrderMaster和orderDetail）
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        //扣库存
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream().map(e->
                new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        //发送websocket消息
        webSocket.sendMessage("有新的订单："+orderDTO.getOrderId());

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster=orderMasterDao.findById(orderId).get();
        if(orderMaster==null)
        {
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList=orderDetailDao.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage=orderMasterDao.findByBuyerOpenid(buyerOpenid,pageable);

        List<OrderDTO> orderDTOList= OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,
                orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster=new OrderMaster();
        //判断订单状态
        //新下单
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【取消订单】订单状态不正确，orderId={},orderStatus={}",orderDTO.getOrderId(),
                    orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if(updateResult==null){
            log.info("【取消订单】 跟新失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返回库存
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【取消订单】 订单中午无商品详情,orderDTO={},",orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream().map(e->
        new CartDTO(e.getProductId(),e.getProductQuantity()) ).collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //如果已支付，需要退款

        if(orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO

        }
        //发送websocket消息
        webSocket.sendMessage(orderDTO.getOrderId()+"取消了订单");

        //推送模板消息
        pushMessage.orderStatus(orderDTO);

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【完结订单】 订单状态不正确,orderId={},orderStatus={}",
                    orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw  new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }


        //修改状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if(updateResult==null){
            log.info("【完结订单】 跟新失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //推送模板消息
        pushMessage.orderStatus(orderDTO);

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【订单支付完成】 订单状态不正确,orderId={},orderStatus={}",
                    orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw  new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }


        //判断支付状态
        if(!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            log.error("【订单支付完成】 订单支付状态不正确 orderDTO={}",orderDTO );
            throw new SellException(ResultEnum.ORDER_PAY_STATUS);
        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if(updateResult==null){
            log.info("【订单支付完成】 跟新失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage=orderMasterDao.findAll(pageable);
        List<OrderDTO> orderDTOList= OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,
                orderMasterPage.getTotalElements());
        return orderDTOPage;
    }
}
