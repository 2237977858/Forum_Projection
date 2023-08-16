package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 发送邮件设置
 */
@Getter
@Setter
public class SysSettingEmail {
    /**
     * 邮箱标题
     */
    private String emailTitle;

    /**
     * 邮箱内容
     */
    private String emailContent;
}
