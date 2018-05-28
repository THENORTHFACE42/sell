package com.lizhenjie.dao;

import com.lizhenjie.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:03 2018/5/11
 * @Modified By:
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String>{

    SellerInfo findByOpenid(String openid);

}
