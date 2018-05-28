package com.lizhenjie.service;

import com.lizhenjie.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 13:46 2018/5/6
 * @Modified By:
 */
public interface OrderService {
    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询订单列表（查询某个人）
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
     OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //查询订单列表（所有）
    Page<OrderDTO> findList( Pageable pageable);



}
