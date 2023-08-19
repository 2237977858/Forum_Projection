package com.noself.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noself.controller.exception.BusinessException;
import com.noself.entity.constants.Constants;
import com.noself.entity.enums.*;
import com.noself.entity.po.UserInfo;
import com.noself.entity.po.UserIntegralRecord;
import com.noself.entity.po.UserMessage;
import com.noself.mapper.UserInfoMapper;
import com.noself.mapper.UserIntegralRecordMapper;
import com.noself.mapper.UserMessageMapper;
import com.noself.service.EmailCodeService;
import com.noself.service.UserInfoService;
import com.noself.utils.StringTools;
import com.noself.utils.SysCacheUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Resource
    private UserMessageMapper userMessageMapper;

    @Resource
    private UserIntegralRecordMapper userIntegralRecordMapper;


    /**
     * 注册账号
     *
     * @param email 邮箱
     * @param emailCode 邮箱验证码
     * @param nickName 用户名
     * @param password 密码
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(String email, String emailCode, String nickName, String password) {
        QueryWrapper emailWrapper = new QueryWrapper();
        emailWrapper.eq("email", email);
        UserInfo userInfo = userInfoMapper.selectOne(emailWrapper);
        if (userInfo != null) {
            throw new BusinessException("邮箱已存在");
        }
        QueryWrapper nameWrapper = new QueryWrapper();
        nameWrapper.eq("nick_name", nickName);
        userInfo = userInfoMapper.selectOne(nameWrapper);
        if(userInfo != null) {
            throw new BusinessException("昵称已存在");
        }
        // 验证邮箱验证码是否正确
        emailCodeService.checkCode(email,emailCode);
        // 插入数据
        UserInfo insertInfo = new UserInfo();
        insertInfo.setEmail(email);
        insertInfo.setNickName(nickName);
        insertInfo.setPassword(StringTools.encodeMd5(password));
        insertInfo.setStatus(UserStatusEnum.ENABLE.getStatus());
        insertInfo.setJoinTime(new Date());
        insertInfo.setTotalIntegral(Constants.ZERO);
        insertInfo.setCurrentIntegral(Constants.ZERO);
        userInfoMapper.insert(insertInfo);
        // 更新用户积分
        Integer userId = insertInfo.getUserId();
        updateUserIntegral(userId, UserIntegralOperTypeEnum.REGISTER, UserIntegralChangeTypeEnum.ADD, Constants.REGISTER_INTEGRAL);
        // 记录消息
        UserMessage userMessage = new UserMessage();
        userMessage.setReceivedUserId(userId);
        userMessage.setMessageType(MessageTypeEnum.SYS.getType());
        userMessage.setCreateTime(new Date());
        userMessage.setStatus(MessageStatusEnum.UNREAD.getStatus());
        userMessage.setMessageContent(SysCacheUtils.getSysCache().getRegisterSetting().getRegisterWelcomInfo());
        userMessageMapper.insert(userMessage);

    }

    /**
     * 更新用户积分
     *
     * @param userId 用户id
     * @param operTypeEnum 操作类型
     * @param changeTypeEnum 加减积分
     * @param integral 积分
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateUserIntegral(Integer userId, UserIntegralOperTypeEnum operTypeEnum, UserIntegralChangeTypeEnum changeTypeEnum, Integer integral) {
        integral = changeTypeEnum.getChangeType() * integral;
        if (integral == 0) {
            return;
        }
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (UserIntegralChangeTypeEnum.REDUCE.getChangeType().equals(changeTypeEnum.getChangeType()) && userInfo.getCurrentIntegral() + integral < 0) {
            integral = changeTypeEnum.getChangeType() * userInfo.getCurrentIntegral();
        }
        // 插入积分记录表
        UserIntegralRecord userIntegralRecord = new UserIntegralRecord();
        userIntegralRecord.setUserId(userId);
        userIntegralRecord.setOperType(operTypeEnum.getOperType());
        userIntegralRecord.setIntegral(integral);
        userIntegralRecord.setCreateTime(new Date());
        userIntegralRecordMapper.insert(userIntegralRecord);
        // 更新用户表当前积分
        Integer count = userInfoMapper.updateIntegral(userId, integral);
        if(count == 0) {
            throw new BusinessException("更新用户积分失败");
        }
    }

}
