package com.noself.exception;

import com.noself.entity.enums.ResponseCodeEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.users.MemoryGroup;
/**
 * @Description: 业务逻辑异常类
 * @Param:
 * @return:
 * @Author: zjl
 * @Date: 2023/6/17
 */

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private ResponseCodeEnum codeEnum;

    private Integer code;

    private String message;

    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String message, Throwable e) {
        super(message,e);
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ResponseCodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.codeEnum = codeEnum;
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
