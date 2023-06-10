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
 * 点赞记录
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("like_record")
public class LikeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "op_id", type = IdType.AUTO)
    private Integer opId;

    /**
     * 操作类型0:文章点赞 1:评论点赞
     */
    @TableField("op_type")
    private Integer opType;

    /**
     * 主体ID
     */
    @TableField("object_id")
    private String objectId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 发布时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 主体作者ID
     */
    @TableField("author_user_id")
    private String authorUserId;


}
