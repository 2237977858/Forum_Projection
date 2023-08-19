package com.noself.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.noself.controller.exception.BusinessException;
import com.noself.entity.config.WebConfig;
import com.noself.entity.constants.Constants;
import com.noself.entity.po.EmailCode;
import com.noself.entity.po.UserInfo;
import com.noself.mapper.EmailCodeMapper;
import com.noself.mapper.UserInfoMapper;
import com.noself.service.EmailCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noself.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;

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

    private static final Logger logger = LoggerFactory.getLogger(EmailCodeServiceImpl.class);

    @Resource
    EmailCodeMapper emailCodeMapper;
    @Resource
    JavaMailSender javaMailSender;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private WebConfig webConfig;

    /**
     * 发送邮箱验证码之前校验,并生成验证码
     * @param email
     * @param type
     */
    @Transactional(rollbackFor = Exception.class)
    public void sendEmailCode(String email, Integer type) {
        // 获取邮箱时填写的验证码
        if (type == Constants.ZERO) {
            QueryWrapper emailWrapper = new QueryWrapper();
            emailWrapper.eq("email", email);
            UserInfo userInfo = userInfoMapper.selectOne(emailWrapper);
            if (userInfo != null) {
                throw new BusinessException("邮箱已存在");
            }
        }
        String code = StringTools.getRandomString(Constants.LENGTH_5);
        sendEmailCodeDo(email, code);
        // 发送邮箱之前将之前的邮箱验证码都设为无效
        new LambdaUpdateChainWrapper<EmailCode>(emailCodeMapper)
                .eq(EmailCode::getEmail, email)
                .eq(EmailCode::getStatus, 0)
                .set(EmailCode::getStatus, 1)
                .update();

        EmailCode emailCode = new EmailCode();
        emailCode.setCode(code);
        emailCode.setEmail(email);
        emailCode.setStatus(Constants.ZERO); // 0:未使用，1：已使用
        emailCode.setCreateTime(new Date());
        emailCodeMapper.insert(emailCode);
    }

    /**
     * 实际发送邮件操作
     * @param toEmail
     * @param code
     */
    public void sendEmailCodeDo(String toEmail, String code) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            // 邮件发送人
            helper.setFrom(webConfig.getSendUserName());
            // 邮件收件人
            helper.setTo(toEmail);
            // 邮箱标题
            helper.setSubject("注册邮箱验证码");
            // 邮箱内容
            helper.setText("邮箱验证码为：" +  code);
            // 设置邮箱发送时间
            helper.setSentDate(new Date());
            // 发送邮箱
            javaMailSender.send(message);
        }catch (Exception e) {
            logger.error("发送邮件失败,email = " + toEmail);
            throw new BusinessException("邮件发送失败");
        }

    }

    /**
     * 验证邮箱验证码
     * @param email
     * @param code
     */
    public void checkCode(String email, String code){
        QueryWrapper<EmailCode> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        wrapper.eq("code", code);
        EmailCode emailCode = emailCodeMapper.selectOne(wrapper);
        if(emailCode == null) {
            throw new BusinessException("邮箱验证码不正确");
        }
        if (emailCode.getStatus() != Constants.ZERO || System.currentTimeMillis() - emailCode.getCreateTime().getTime() > 1000 * 60 * Constants.EMAIL_CODE_EXPIRE_TIME) {
            throw new BusinessException("邮箱验证码已失效");
        }
        // 发送邮箱之前将之前的邮箱验证码都设为无效
        new LambdaUpdateChainWrapper<EmailCode>(emailCodeMapper)
                .eq(EmailCode::getEmail, email)
                .eq(EmailCode::getStatus, 0)
                .set(EmailCode::getStatus, 1)
                .update();
    }
}
