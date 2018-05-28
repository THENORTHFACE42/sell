package com.lizhenjie.dao;

import com.lizhenjie.dataobject.SellerInfo;
import com.lizhenjie.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:05 2018/5/11
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SellerInfoDaoTest {

    @Autowired
    SellerInfoDao sellerInfoDao;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOpenid() throws Exception{
        SellerInfo result=sellerInfoDao.findByOpenid("abc");
        Assert.assertEquals("abc",result.getOpenid());
    }


}