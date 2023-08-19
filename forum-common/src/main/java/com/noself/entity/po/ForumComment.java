package com.noself.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("forum_comment")
public class ForumComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 父级评论ID
     */
    @TableField("p_comment_id")
    private Integer pCommentId;

    /**
     * 文章ID
     */
    @TableField("article_id")
    private String articleId;

    /**
     * 回复内容
     */
    @TableField("content")
    private String content;

    /**
     * 图片
     */
    @TableField("img_path")
    private String imgPath;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户ip地址
     */
    @TableField("user_ip_address")
    private String userIpAddress;

    /**
     * 回复人ID
     */
    @TableField("reply_user_id")
    private String replyUserId;

    /**
     * 回复人昵称
     */
    @TableField("reply_nick_name")
    private String replyNickName;

    /**
     * 0:未置顶  1:置顶
     */
    @TableField("top_type")
    private Integer topType;

    /**
     * 发布时间
     */
    @TableField("post_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date postTime;

    /**
     * good数量
     */
    @TableField("good_count")
    private Integer goodCount;

    /**
     * 0:待审核  1:已审核
     */
    @TableField("status")
    private Integer status;


}
