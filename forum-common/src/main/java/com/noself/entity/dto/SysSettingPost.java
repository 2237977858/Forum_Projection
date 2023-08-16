package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 发帖设置
 */
@Getter
@Setter
public class SysSettingPost {

    /**
     * 附件大小 单位MB
     */
    private Integer attachmentSize;

    /**
     * 每天可上传图片数量
     */
    private Integer dayImageUploadCount;

    /**
     * 每天可发帖数量
     */
    private Integer postDayCountThreshold;

    /**
     * 发帖积分
     */
    private Integer postIntegral;
}
