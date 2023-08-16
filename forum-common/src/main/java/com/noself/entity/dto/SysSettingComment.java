package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 评论设置
 */
@Getter
@Setter
public class SysSettingComment {
    /**
     * 评论积分
     */
    private Integer commentIntegral;

    /**
     * 评论数量阈值
     */
    private Integer commentDayCountThreshold;

    /**
     * 是否开启评论
     */
    private Boolean commentOpen;
}
