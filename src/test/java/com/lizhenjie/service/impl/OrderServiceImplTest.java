package com.lizhenjie.service.impl;

import com.lizhenjie.dao.OrderMasterDao;
import com.lizhenjie.dataobject.OrderDetail;
import com.lizhenjie.dto.OrderDTO;
import com.lizhenjie.enums.OrderStatusEnum;
import com.lizhenjie.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 21:25 2018/5/6
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String BUYER_IPENID="110110";

    private final String ORDER_ID="1525615967588720235";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("李先生");
        orderDTO.setBuyerPhone("12345678910");
        orderDTO.setBuyerAddress("1号餐桌");
        orderDTO.setBuyerOpenid(BUYER_IPENID);

        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();

        OrderDetail o1=new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);

        OrderDetail o2=new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);


        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result=orderService.create(orderDTO);
        log.info("【创建订单】 result=[]",result );

    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result=orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}",result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(BUYER_IPENID, pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());

    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list() throws Exception{
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

}