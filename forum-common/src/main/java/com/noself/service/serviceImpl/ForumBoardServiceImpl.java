package com.noself.service.serviceImpl;

import com.noself.entity.ForumBoard;
import com.noself.mapper.ForumBoardMapper;
import com.noself.service.ForumBoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章板块信息 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class ForumBoardServiceImpl extends ServiceImpl<ForumBoardMapper, ForumBoard> implements ForumBoardService {

}
