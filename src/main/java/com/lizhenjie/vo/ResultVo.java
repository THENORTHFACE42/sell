package com.lizhenjie.vo;

import lombok.Data;

/**
 * @author lizhenjie
 * @Description: http请求返回的最外层对象
 * @Date :Created in 21:10 2018/5/3
 * @Modified By:
 */
@Data
public class ResultVo<T> {
    //错误码 0为成功
    private Integer code;
    //提示信息
    private String msg;
    //返回的具体内容
    private T data;

}
