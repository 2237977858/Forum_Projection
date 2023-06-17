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
 * 文章板块信息
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("forum_board")
public class ForumBoard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 板块ID
     */
    @TableId(value = "board_id", type = IdType.AUTO)
    private Integer boardId;

    /**
     * 父级板块ID
     */
    @TableField("p_board_id")
    private Integer pBoardId;

    /**
     * 板块名
     */
    @TableField("board_name")
    private String boardName;

    /**
     * 封面
     */
    @TableField("cover")
    private String cover;

    /**
     * 描述
     */
    @TableField("board_desc")
    private String boardDesc;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 0:只允许管理员发帖 1:任何人可以发帖
     */
    @TableField("post_type")
    private Boolean postType;


}
