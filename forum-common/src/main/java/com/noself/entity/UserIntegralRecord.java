package com.noself.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户积分记录表
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_integral_record")
public class UserIntegralRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 操作类型
     */
    @TableField("oper_type")
    private Integer operType;

    /**
     * 积分
     */
    @TableField("integral")
    private Integer integral;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
