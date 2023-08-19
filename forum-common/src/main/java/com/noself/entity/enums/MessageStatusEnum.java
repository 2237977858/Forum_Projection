package com.noself.entity.enums;

import lombok.Getter;

/**
 * 消息状态枚举
 */

@Getter
public enum MessageStatusEnum {

    UNREAD(0, "未读"),
    READ(1, "已读");

    private Integer status;
    private String desc;

    /**
     * 通过status获取对应的枚举对象
     *
     * @param status status值
     * @return
     */
    public static MessageStatusEnum getByStatus(Integer status) {
        for (MessageStatusEnum messageStatusEnum : MessageStatusEnum.values()) {
            if(messageStatusEnum.getStatus().equals(status)) {
                return messageStatusEnum;
            }
        }
        return null;
    }

    MessageStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
