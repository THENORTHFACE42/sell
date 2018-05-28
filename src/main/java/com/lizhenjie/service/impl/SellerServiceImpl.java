package com.lizhenjie.service.impl;

import com.lizhenjie.dao.SellerInfoDao;
import com.lizhenjie.dataobject.SellerInfo;
import com.lizhenjie.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:29 2018/5/11
 * @Modified By:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
