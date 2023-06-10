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
 * 邮箱验证码
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("email_code")
public class EmailCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    @TableId(value = "email", type = IdType.AUTO)
    private String email;

    /**
     * 编号
     */
    @TableId(value = "code", type = IdType.AUTO)
    private String code;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 0:未使用  1:已使用
     */
    @TableField("status")
    private Boolean status;


}
