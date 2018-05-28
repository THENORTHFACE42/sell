package com.lizhenjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lizhenjie
 * @Description:商品详情
 * @Date :Created in 21:41 2018/5/3
 * @Modified By:
 */
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
