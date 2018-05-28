package com.lizhenjie.service;

import com.lizhenjie.dto.OrderDTO;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 20:54 2018/5/7
 * @Modified By:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消一个订单
    OrderDTO cancelOrder(String openid,String orderId);

}
