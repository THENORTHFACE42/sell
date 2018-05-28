package com.lizhenjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lizhenjie
 * @Description: 商品（包含类目）
 * @Date :Created in 21:32 2018/5/3
 * @Modified By:
 */
@Data
public class ProductVo {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
