package com.noself.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统设置信息
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_setting")
public class SysSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "code", type = IdType.AUTO)
    private String code;

    /**
     * 设置信息
     */
    @TableField("json_content")
    private String jsonContent;


}
