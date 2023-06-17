package com.noself.entity.po;

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
 * 用户附件下载
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("forum_article_attachment_download")
public class ForumArticleAttachmentDownload implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    @TableId(value = "file_id", type = IdType.AUTO)
    private String fileId;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    /**
     * 文章ID
     */
    @TableField("article_id")
    private String articleId;

    /**
     * 文件下载次数
     */
    @TableField("download_count")
    private Integer downloadCount;


}
