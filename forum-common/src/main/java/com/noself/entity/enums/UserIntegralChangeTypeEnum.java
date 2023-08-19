package com.noself.entity.enums;

import lombok.Getter;


/**
 * 积分加减枚举类
 */
@Getter
public enum UserIntegralChangeTypeEnum {

    ADD(1, "增加"),
    REDUCE(-1, "减少");

    private Integer changeType;
    private String desc;

    UserIntegralChangeTypeEnum(Integer changeType, String desc) {
        this.changeType = changeType;
        this.desc = desc;
    }
}
