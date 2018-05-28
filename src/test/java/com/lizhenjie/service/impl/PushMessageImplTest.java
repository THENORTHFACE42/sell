package com.lizhenjie.service.impl;

import com.lizhenjie.dto.OrderDTO;
import com.lizhenjie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 17:15 2018/5/11
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PushMessageImplTest {

    @Autowired
   private  PushMessageImpl pushMessage;

    @Autowired
    OrderService orderService;
    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO=orderService.findOne("1525847589966896865");
        pushMessage.orderStatus(orderDTO);

    }

}