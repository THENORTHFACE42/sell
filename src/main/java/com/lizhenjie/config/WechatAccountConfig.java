package com.lizhenjie.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 10:05 2018/5/8
 * @Modified By:
 */
@Data
@Component
@PropertySource("application.yml")
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;

    /**
     * 微信模板id
     */
    private Map<String,String> templateId;

}
