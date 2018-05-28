package com.lizhenjie.dao;

import com.lizhenjie.dataobject.ProductInfo;
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
 * @Date :Created in 19:36 2018/5/3
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest()
    {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3));
        productInfo.setProductStock(30);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result=productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList= productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }


}