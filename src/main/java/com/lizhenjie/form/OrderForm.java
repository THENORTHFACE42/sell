package com.lizhenjie.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 9:10 2018/5/7
 * @Modified By:
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址（买家餐桌号）
     */
    @NotEmpty(message = "买家餐桌号")
    private String address;

    /**
     * 买家id
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车项
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
