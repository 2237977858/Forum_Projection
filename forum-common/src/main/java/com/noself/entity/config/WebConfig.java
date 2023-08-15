package com.noself.entity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 用于读取 .properties配置文件中的值
 * @Author: zjl
 * @Date: 2023/8/12
 */

@Component
public class WebConfig {

    @Value("${spring.mail.username:}")
    private String sendUserName;

    public String getSendUserName() {
        return sendUserName;
    }
}
