package com.noself.controller;

import com.noself.controller.exception.BusinessException;
import com.noself.entity.constants.Constants;
import com.noself.entity.dto.CreateImageCode;
import com.noself.entity.enums.ResponseCodeEnum;
import com.noself.entity.po.UserInfo;
import com.noself.entity.vo.ResponseVo;
import com.noself.service.EmailCodeService;
import com.noself.service.UserInfoService;
import com.noself.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class AccountController extends ABaseController{

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Resource
    private EmailCodeService emailCodeService;
    @Resource
    private UserInfoService userInfoService;

    /**
     * 获取图片验证码
     */
    @GetMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws IOException {
        CreateImageCode vCode = new CreateImageCode(130,38,5,10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Express", 0);
        response.setContentType("image/jpeg");
        BufferedImage image = vCode.getImage();
        String code = vCode.getText();
        // 登录时填写的图片验证码
        if (type == null || type == 0) {
            session.setAttribute(Constants.CHECK_CODE_KEY, code);
        }else {
            // 注册获取邮箱验证码时，需要填写的图片验证码
            session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
        }
        CreateImageCode.output(image,response.getOutputStream());
    }

    /**
     * 发送邮箱验证码
     * @param session
     * @param email
     * @param checkCode
     * @param type
     * @return
     */
    @GetMapping("/sendEmailCode")
    public ResponseVo sendEmailCode(HttpSession session, String email, String checkCode, Integer type) {
        try {
            if (StringTools.isEmpty(email) || StringTools.isEmpty(checkCode) || type == null) {
                throw new BusinessException(ResponseCodeEnum.CODE_400);
            }
            if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))) {
                throw new BusinessException("图片验证码错误");
            }
            emailCodeService.sendEmailCode(email, type);
            return getSuccessResponseVO(null);
        }finally {
            // 发送完验证码之后移除
            session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
        }
    }

    /**
     * 注册账号
     * @param session
     * @param email
     * @param emailCode 邮箱验证码
     * @param nickName
     * @param password
     * @param checkCode 图片验证码
     * @return
     */
    @GetMapping("/register")
    public ResponseVo register(HttpSession session, String email, String emailCode, String nickName, String password, String checkCode) {
        try {
            if (StringTools.isEmpty(email) || StringTools.isEmpty(emailCode) || StringTools.isEmpty(nickName) || StringTools.isEmpty(password) || StringTools.isEmpty(checkCode)) {
                throw new BusinessException(ResponseCodeEnum.CODE_400);
            }
            if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY))) {
                throw new BusinessException("图片验证码错误");
            }
            // 注册操作
            userInfoService.register(email, emailCode, nickName, password);
            return getSuccessResponseVO(null);
        }finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY);
        }
    }
}
