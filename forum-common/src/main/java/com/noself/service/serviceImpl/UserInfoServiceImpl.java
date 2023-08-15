package com.noself.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noself.controller.exception.BusinessException;
import com.noself.entity.constants.Constants;
import com.noself.entity.enums.UserStatusEnum;
import com.noself.entity.po.UserInfo;
import com.noself.mapper.EmailCodeMapper;
import com.noself.mapper.UserInfoMapper;
import com.noself.service.EmailCodeService;
import com.noself.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noself.utils.StringTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Date;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private EmailCodeService emailCodeService;

    /**
     * 根据邮箱获取用户信息
     * @param email
     * @return
     */
    @Override
    public UserInfo selectByEmail(String email) {
        return userInfoMapper.selectByEmail(email);
    }

    /**
     * 注册账号
     * @param email
     * @param emailCode
     * @param nickName
     * @param password
     */
    @Override
    public void register(String email, String emailCode, String nickName, String password) {
        UserInfo userInfo = userInfoMapper.selectByEmail(email);
        if (userInfo != null) {
            throw new BusinessException("邮箱已存在");
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("nick_name", nickName);
        userInfo = userInfoMapper.selectOne(wrapper);
        if(userInfo != null) {
            throw new BusinessException("昵称已存在");
        }
        // 验证邮箱验证码是否正确
        emailCodeService.checkCode(email,emailCode);
        // 插入数据
        String userId = StringTools.getRandomNumber(Constants.LENGTH_10);
        UserInfo insertInfo = new UserInfo();
        insertInfo.setUserId(userId);
        insertInfo.setEmail(email);
        insertInfo.setNickName(nickName);
        insertInfo.setPassword(StringTools.encodeMd5(password));
        insertInfo.setStatus(UserStatusEnum.ENABLE.getStatus());
        insertInfo.setJoinTime(new Date());
        insertInfo.setTotalIntegral(Constants.ZERO);
        insertInfo.setCurrentIntegral(Constants.ZERO);
        userInfoMapper.insert(insertInfo);
        // 读取积分配置
    }
}
