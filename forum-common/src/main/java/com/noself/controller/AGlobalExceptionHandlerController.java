package com.noself.controller;

import com.noself.entity.enums.ResponseCodeEnum;
import com.noself.entity.vo.ResponseVo;
import com.noself.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
/**
 * @Description: 全局异常处理器
 * @Param:
 * @return:
 * @Author: zjl
 * @Date: 2023/6/17
 */


@RestControllerAdvice
public class AGlobalExceptionHandlerController extends ABaseController{

    private static final Logger logger = LoggerFactory.getLogger(AGlobalExceptionHandlerController.class);

    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        logger.error("请求错误, 请求地址{}, 错误信息:", request.getRequestURI(), e);
        ResponseVo ajaxResponse = new ResponseVo();
        if (e instanceof NoHandlerFoundException) {
            // 404
            ajaxResponse.setCode(ResponseCodeEnum.CODE_404.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_404.getMsg());
            ajaxResponse.setStatus(STATUS_ERROR);
        } else if (e instanceof BusinessException) {
            // 业务错误
            BusinessException biz = (BusinessException) e;
            ajaxResponse.setCode(ResponseCodeEnum.CODE_404.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_404.getMsg());
            ajaxResponse.setStatus(STATUS_ERROR);
        } else if (e instanceof BindException) {
            // 参数类型错误
            ajaxResponse.setCode(ResponseCodeEnum.CODE_400.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_400.getMsg());
            ajaxResponse.setStatus(STATUS_ERROR);
        } else if (e instanceof DuplicateKeyException) {
            // 主键冲突
            ajaxResponse.setCode(ResponseCodeEnum.CODE_601.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_601.getMsg());
            ajaxResponse.setStatus(STATUS_ERROR);
        } else {
            // 服务器错误
            ajaxResponse.setCode(ResponseCodeEnum.CODE_500.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_500.getMsg());
            ajaxResponse.setStatus(STATUS_ERROR);
        }
        return ajaxResponse;
    }

}
