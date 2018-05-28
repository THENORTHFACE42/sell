package com.lizhenjie.enums;

import lombok.Getter;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 15:04 2018/5/4
 * @Modified By:
 */
@Getter
public enum  PayStatusEnum implements CodeEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");


    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
