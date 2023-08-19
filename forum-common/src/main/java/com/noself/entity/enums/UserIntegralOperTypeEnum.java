package com.noself.entity.enums;

import lombok.Getter;

/**
 * 用户积分操作类型枚举
 */
@Getter
public enum UserIntegralOperTypeEnum {
    REGISTER(1, "注册账号"),
    USER_DOWNLOAD_ATTACHMENT(2, "下载附件"),
    DOWNLOAD_ATTACHMENT(3, "附件被下载"),
    POST_COMMENT(4, "发布评论"),
    POST_ARTICLE(5, "发布文章"),
    ADMIN(6, "管理员操作"),
    DEL_ARTICLE(7, "文章被删除"),
    DEL_COMMENT(8, "评论被删除");


    private Integer operType;
    private String desc;

    /**
     * 通过operType获取对应的枚举对象
     *
     * @param operType operType值
     * @return
     */
    public static UserIntegralOperTypeEnum getByStatus(Integer operType) {
        for (UserIntegralOperTypeEnum userIntegralOperTypeEnum : UserIntegralOperTypeEnum.values()) {
            if(userIntegralOperTypeEnum.getOperType().equals(operType)) {
                return userIntegralOperTypeEnum;
            }
        }
        return null;
    }

    UserIntegralOperTypeEnum(Integer operType, String desc) {
        this.operType = operType;
        this.desc = desc;
    }
}
