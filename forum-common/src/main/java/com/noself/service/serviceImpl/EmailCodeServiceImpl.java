package com.noself.service.serviceImpl;

import com.noself.entity.EmailCode;
import com.noself.mapper.EmailCodeMapper;
import com.noself.service.EmailCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 邮箱验证码 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class EmailCodeServiceImpl extends ServiceImpl<EmailCodeMapper, EmailCode> implements EmailCodeService {

}
