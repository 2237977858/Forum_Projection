package com.noself.mapper;

import com.noself.entity.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    Integer updateIntegral(Integer userId, Integer integral);
}
