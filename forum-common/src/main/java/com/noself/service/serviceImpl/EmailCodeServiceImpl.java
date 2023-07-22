package com.noself.service.serviceImpl;

import com.noself.controller.exception.BusinessException;
import com.noself.entity.po.EmailCode;
import com.noself.entity.po.UserInfo;
import com.noself.mapper.EmailCodeMapper;
import com.noself.mapper.UserInfoMapper;
import com.noself.service.EmailCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private UserInfoMapper userInfoMapper;

    public void sendEmailCode(String email, Integer type) {
        // 获取邮箱时填写的验证码
        if (type == 0) {
            UserInfo userInfo = userInfoMapper.selectByEmail(email);
            if (userInfo != null) {
                throw new BusinessException("邮箱已存在");
            }
        }
    }
}
