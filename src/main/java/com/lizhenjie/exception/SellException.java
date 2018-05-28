package com.lizhenjie.exception;

import com.lizhenjie.enums.ResultEnum;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 14:36 2018/5/6
 * @Modified By:
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
