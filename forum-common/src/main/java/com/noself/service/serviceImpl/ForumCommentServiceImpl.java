package com.noself.service.serviceImpl;

import com.noself.entity.po.ForumComment;
import com.noself.mapper.ForumCommentMapper;
import com.noself.service.ForumCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class ForumCommentServiceImpl extends ServiceImpl<ForumCommentMapper, ForumComment> implements ForumCommentService {

}
