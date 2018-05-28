package com.lizhenjie.service;

import com.lizhenjie.dto.OrderDTO;

/**
 * @author lizhenjie
 * @Description: 消息推送
 * @Date :Created in 16:53 2018/5/11
 * @Modified By:
 */
public interface PushMessage {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
