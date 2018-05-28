package com.lizhenjie.dao;

import com.lizhenjie.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 19:33 2018/5/3
 * @Modified By:
 */
//extends中<>为实体类及实体类主键类型
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
