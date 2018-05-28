package com.lizhenjie.service;

import com.lizhenjie.dataobject.ProductInfo;
import com.lizhenjie.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 19:49 2018/5/3
 * @Modified By:
 */

public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save (ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);


    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
