package com.lizhenjie.service.impl;

import com.lizhenjie.config.WechatAccountConfig;
import com.lizhenjie.dto.OrderDTO;
import com.lizhenjie.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:55 2018/5/11
 * @Modified By:
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage=new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data= Arrays.asList(
                new WxMpTemplateData("first","欢迎下次光临"),
                new WxMpTemplateData("keyword1","毕业设计餐馆"),
                new WxMpTemplateData("keyword2",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword3",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword4","￥"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","用餐愉快！")

        );

        templateMessage.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败{}",e);
            e.printStackTrace();
        }
    }
}
