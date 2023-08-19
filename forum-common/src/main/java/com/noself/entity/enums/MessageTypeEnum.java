package com.noself.entity.enums;

import lombok.Getter;

/**
 * 消息类型枚举
 */

@Getter
public enum MessageTypeEnum {

    SYS(0, "sys", "系统消息"),
    COMMENT(1, "reply", "回复我的"),
    ARTICLE_LIKE(2, "likePost", "赞了我的文章"),
    COMMENT_LIKE(3, "likeComment", "赞了我的评论"),
    DOWNLOAD_ATTACHMENT(4, "downloadAttachment", "下载了我的附件");

    // 消息类型
    private Integer type;
    // 消息类型对应的路径
    private String code;
    // 消息描述
    private String desc;

    /**
     * 通过code获取对应的枚举对象
     *
     * @param code code值
     * @return
     */
    public static MessageTypeEnum getByCode(String code) {
        for (MessageTypeEnum messageTypeEnum : MessageTypeEnum.values()) {
            if(messageTypeEnum.getCode().equals(code)) {
                return messageTypeEnum;
            }
        }
        return null;
    }

    MessageTypeEnum(Integer type, String code, String desc) {
        this.type = type;
        this.code = code;
        this.desc = desc;
    }

}
