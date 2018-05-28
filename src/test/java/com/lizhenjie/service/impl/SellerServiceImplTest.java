package com.lizhenjie.service.impl;

import com.lizhenjie.dataobject.SellerInfo;
import com.lizhenjie.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:29 2018/5/11
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class SellerServiceImplTest {

    private static  final  String openid="abc";
    @Autowired
    SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo result=sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,result.getOpenid());


    }

}