package com.lizhenjie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lizhenjie.dataobject.OrderDetail;
import com.lizhenjie.enums.OrderStatusEnum;
import com.lizhenjie.enums.PayStatusEnum;
import com.lizhenjie.utils.EnumUtil;
import com.lizhenjie.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 14:03 2018/5/6
 * @Modified By:
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    //订单ID
    private String orderId;

    //买家名字
    private String buyerName;

    //买家手机号
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态，默认为新下单
    private Integer orderStatus;

    //支付状态，默认为未支付
    private Integer payStatus;

    //创建时间

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
