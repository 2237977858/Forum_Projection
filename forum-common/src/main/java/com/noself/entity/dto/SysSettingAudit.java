package com.noself.entity.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 审核设置
 */
@Getter
@Setter
public class SysSettingAudit {
    /**
     * 帖子是否需要审核
     */
    private Boolean postAudit;

    /**
     * 评论是否需要审核
     */
    private Boolean commentAudit;

}
