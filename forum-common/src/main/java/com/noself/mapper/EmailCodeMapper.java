package com.noself.mapper;

import com.noself.entity.po.EmailCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 邮箱验证码 Mapper 接口
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Mapper
public interface EmailCodeMapper extends BaseMapper<EmailCode> {

}
