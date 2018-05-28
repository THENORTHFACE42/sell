package com.lizhenjie.dao;

import com.lizhenjie.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:40 2018/5/4
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String   OPENID="110110";


    @Test
    public void saveTest() throws Exception{
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("帅哥");
        orderMaster.setBuyerPhone("12345678910");
        orderMaster.setBuyerAddress("东区九栋");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster resultMaste=orderMasterDao.save(orderMaster);
        Assert.assertNotNull(resultMaste);
    }

    @Test
    public void findByBuyerOpenId() throws Exception {

        PageRequest request=new PageRequest(0,1);
        Page<OrderMaster> result=orderMasterDao.findByBuyerOpenid(OPENID,request);
        System.out.print(result.getTotalElements());


    }

}