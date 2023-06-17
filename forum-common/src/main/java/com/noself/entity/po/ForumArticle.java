package com.noself.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 文章信息
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("forum_article")
public class ForumArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private String articleId;

    /**
     * 板块ID
     */
    @TableField("board_id")
    private Integer boardId;

    /**
     * 板块名称
     */
    @TableField("board_name")
    private String boardName;

    /**
     * 父级板块ID
     */
    @TableField("p_board_id")
    private Integer pBoardId;

    /**
     * 父板块名称
     */
    @TableField("p_board_name")
    private String pBoardName;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 最后登录ip地址
     */
    @TableField("user_ip_address")
    private String userIpAddress;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * markdown内容
     */
    @TableField("markdown_content")
    private String markdownContent;

    /**
     * 0:富文本编辑器 1:markdown编辑器
     */
    @TableField("editor_type")
    private Integer editorType;

    /**
     * 摘要
     */
    @TableField("summary")
    private String summary;

    /**
     * 发布时间
     */
    @TableField("post_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postTime;

    /**
     * 最后更新时间
     */
    @TableField("last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateTime;

    /**
     * 阅读数量
     */
    @TableField("read_count")
    private Integer readCount;

    /**
     * 点赞数
     */
    @TableField("good_count")
    private Integer goodCount;

    /**
     * 评论数
     */
    @TableField("comment_count")
    private Integer commentCount;

    /**
     * 0未置顶  1:已置顶
     */
    @TableField("top_type")
    private Integer topType;

    /**
     * 0:没有附件  1:有附件
     */
    @TableField("attachment_type")
    private Integer attachmentType;

    /**
     * -1已删除 0:待审核  1:已审核 
     */
    @TableField("status")
    private Integer status;


}
