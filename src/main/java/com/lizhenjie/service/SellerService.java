package com.lizhenjie.service;

import com.lizhenjie.dataobject.SellerInfo;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:28 2018/5/11
 * @Modified By:
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}

