package com.noself.service;

import com.noself.entity.po.EmailCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 邮箱验证码 服务类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
public interface EmailCodeService extends IService<EmailCode> {

    void sendEmailCode(String email, Integer type);

    void sendEmailCodeDo(String toEmail, String code);

    void checkCode(String email, String code);

}
