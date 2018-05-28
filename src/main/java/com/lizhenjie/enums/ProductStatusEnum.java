package com.lizhenjie.enums;

import lombok.Getter;

/**
 * @author lizhenjie
 * @Description:商品状态
 * @Date :Created in 19:58 2018/5/3
 * @Modified By:
 */
@Getter
public enum  ProductStatusEnum implements  CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
