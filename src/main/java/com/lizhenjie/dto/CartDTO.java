package com.lizhenjie.dto;

import lombok.Getter;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 20:50 2018/5/6
 * @Modified By:
 */
@Getter
public class CartDTO {
    //商品id
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
