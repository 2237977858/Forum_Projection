package com.noself.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 接口返回结果
 * @Param:
 * @return:
 * @Author: zjl
 * @Date: 2023/6/17
 */


@Getter
@Setter
public class ResponseVo<T>{
    /**
     * 状态
     */
    private String status;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 请求信息
     */
    private String Info;
    /**
     * 返回的数据
     */
    private T data;
}
