package com.noself.entity.enums;

import lombok.Getter;

/**
 * 设置类枚举对象映射
 */
@Getter
public enum SysSettingCodeEnum {

    AUDIT("audit", "com.noself.entity.dto.SysSettingAudit", "auditSetting", "审核设置"),
    COMMENT("comment", "com.noself.entity.dto.SysSettingComment", "commentSetting", "评论设置"),
    EMAIL("email", "com.noself.entity.dto.SysSettingEmail", "emailSetting", "邮箱设置"),
    LIKE("like", "com.noself.entity.dto.SysSettingLike", "likeSetting", "点赞设置"),
    POST("post", "com.noself.entity.dto.SysSettingPost", "postSetting", "帖子设置"),
    REGISTER("register", "com.noself.entity.dto.SysSettingRegister", "registerSetting", "注册设置");

    // 数据库sys_setting中对应的code值
    private String code;
    // 映射对象的全路径
    private String classZ;
    // 在SysSettingDto中对应的成员变量
    private String propName;
    // 描述
    private String desc;

    /**
     * 通过code获取对应的枚举对象
     *
     * @param code code值
     * @return
     */
    public static SysSettingCodeEnum getByCode(String code) {
        for (SysSettingCodeEnum sysSettingCodeEnum : SysSettingCodeEnum.values()) {
            if(sysSettingCodeEnum.getCode().equals(code)) {
                return sysSettingCodeEnum;
            }
        }
        return null;
    }

    SysSettingCodeEnum(String code, String classZ, String propName, String desc) {
        this.code = code;
        this.classZ = classZ;
        this.propName = propName;
        this.desc = desc;
    }

}
