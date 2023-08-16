package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 点赞设置
 */
@Getter
@Setter
public class SysSettingLike {
    /**
     * 点赞阈值
     */
    private Integer likeDayCountThreshold;
}
