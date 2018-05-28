package com.lizhenjie.dao;

import com.lizhenjie.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 17:26 2018/5/4
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;


    @Test
    public void saveTest()
    {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(2);

        OrderDetail resultDetail=orderDetailDao.save(orderDetail);
        Assert.assertNotNull(resultDetail);

    }
    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList=orderDetailDao.findByOrderId("11111111");
        Assert.assertNotEquals(0,orderDetailList.size());

    }

}