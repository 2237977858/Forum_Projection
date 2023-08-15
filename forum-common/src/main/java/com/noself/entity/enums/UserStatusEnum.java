package com.noself.entity.enums;

import lombok.Getter;

/**
 * @Description: 返回码
 * @Param:
 * @return:
 * @Author: zjl
 * @Date: 2023/6/17
 */


@Getter
public enum UserStatusEnum {
    DISABLE(0, "禁用"),
    ENABLE(1, "正常");


    private Integer status;
    private String desc;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

}
