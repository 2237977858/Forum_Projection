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
public enum ResponseCodeEnum {
    CODE_200(200, "请求成功"),
    CODE_400(400, "请求参数错误"),
    CODE_404(404, "请求地址不存在"),
    CODE_500(500, "服务器错误"),
    CODE_601(601, "信息已存在");


    private Integer code;
    private String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
