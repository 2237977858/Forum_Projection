package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 设置类
 */
@Getter
@Setter
public class SysSettingDto {
    /**
     * 审核设置
     */
    private SysSettingAudit auditSetting;

    /**
     * 评论设置
     */
    private SysSettingComment commentSetting;

    /**
     * 发送邮件设置
     */
    private SysSettingEmail emailSetting;

    /**
     * 点赞设置
     */
    private SysSettingLike likeSetting;

    /**
     * 发帖设置
     */
    private SysSettingPost postSetting;

    /**
     * 注册设置
     */
    private SysSettingRegister registerSetting;
}
