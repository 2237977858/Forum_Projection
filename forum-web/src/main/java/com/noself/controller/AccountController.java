package com.noself.controller;

import com.noself.entity.dto.CreateImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class AccountController extends ABaseController{
    /**
     * 获取验证码
     */
    @GetMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) {
        CreateImageCode vCode = new CreateImageCode(130,38,5,10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Express", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getText();
        // 登录注册
        if (type == null || type == 0) {

        }else {
            // 获取邮箱
        }

    }
}
