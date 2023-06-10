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
 * 用户信息
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 0:女 1:男
     */
    @TableField("sex")
    private Boolean sex;

    /**
     * 个人描述
     */
    @TableField("person_description")
    private String personDescription;

    /**
     * 加入时间
     */
    @TableField("join_time")
    private LocalDateTime joinTime;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 最后登录IP
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登录ip地址
     */
    @TableField("last_login_ip_address")
    private String lastLoginIpAddress;

    /**
     * 积分
     */
    @TableField("total_integral")
    private Integer totalIntegral;

    /**
     * 当前积分
     */
    @TableField("current_integral")
    private Integer currentIntegral;

    /**
     * 0:禁用 1:正常
     */
    @TableField("status")
    private Integer status;


}
