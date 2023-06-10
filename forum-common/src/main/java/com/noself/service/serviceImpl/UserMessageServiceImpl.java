package com.noself.service.serviceImpl;

import com.noself.entity.UserMessage;
import com.noself.mapper.UserMessageMapper;
import com.noself.service.UserMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户消息 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {

}
