package com.lizhenjie.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 15:24 2018/5/4
 * @Modified By:
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;

    //订单Id
    private String orderId;

    //商品id
    private String productId;

    //商品名称
    private String productName;

   //商品单价
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    //商品小图
    private String productIcon;







}
