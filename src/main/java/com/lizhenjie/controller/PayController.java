package com.lizhenjie.controller;

import com.lizhenjie.dto.OrderDTO;
import com.lizhenjie.enums.ResultEnum;
import com.lizhenjie.exception.SellException;
import com.lizhenjie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:20 2018/5/9
 * @Modified By:
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public String create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl) {

        //查询订单
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        //改变支付状态
        orderService.paid(orderDTO);

        return "redirect:" + returnUrl + "?orderId=" + orderId;
    }

}
