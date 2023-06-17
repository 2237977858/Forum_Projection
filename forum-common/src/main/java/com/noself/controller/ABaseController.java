package com.noself.controller;

import com.noself.entity.enums.ResponseCodeEnum;
import com.noself.entity.vo.ResponseVo;
import com.noself.exception.BusinessException;

public class ABaseController {

    protected static final String STATUS_SUCCESS = "success";

    protected static final String STATUS_ERROR = "error";

    protected <T> ResponseVo getSuccessResponseVO(T t) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setStatus(STATUS_SUCCESS);
        responseVo.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVo.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVo.setData(t);
        return responseVo;
    }

    protected <T> ResponseVo getServerErrorResponseVO(T t) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(STATUS_ERROR);
        responseVo.setCode(ResponseCodeEnum.CODE_500.getCode());
        responseVo.setInfo(ResponseCodeEnum.CODE_500.getMsg());
        responseVo.setData(t);
        return responseVo;
    }

    protected <T> ResponseVo getBusinessErrorResponseVO(BusinessException e, T t) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(STATUS_ERROR);
        if(e.getCode() == null) {
            responseVo.setCode(ResponseCodeEnum.CODE_400.getCode());
        }else {
            responseVo.setCode(e.getCode());
        }
        responseVo.setInfo(e.getMessage());
        responseVo.setData(t);
        return responseVo;
    }
}
