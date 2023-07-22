package com.noself.controller;

import com.noself.controller.exception.BusinessException;
import com.noself.entity.constants.Constants;
import com.noself.entity.dto.CreateImageCode;
import com.noself.entity.enums.ResponseCodeEnum;
import com.noself.entity.vo.ResponseVo;
import com.noself.service.EmailCodeService;
import com.noself.utils.StringTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class AccountController extends ABaseController{

    @Resource
    private EmailCodeService emailCodeService;

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

    @GetMapping("/sendEmailCode")
    public ResponseVo sendEmailCode(HttpSession session, String email, String checkCode, Integer type) {
        if (StringTools.isEmpty(email) || StringTools.isEmpty(checkCode) || type == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_400);
        }
        return null;
    }

    /**
     * 校验注册时的图片验证码
     * @param session
     * @param checkCode
     * @return
     */
    @GetMapping("/register")
    public ResponseVo register(HttpSession session, String checkCode) {
        String sessionCode = session.getAttribute(Constants.CHECK_CODE_KEY).toString();
        if(sessionCode.equalsIgnoreCase(checkCode)) {
            return getSuccessResponseVO("验证成功");
        }else {
            throw new BusinessException("验证失败");
        }

    }
}
