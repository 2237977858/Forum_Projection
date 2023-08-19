package com.noself.service;

import com.noself.entity.enums.UserIntegralChangeTypeEnum;
import com.noself.entity.enums.UserIntegralOperTypeEnum;
import com.noself.entity.po.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(String email, String emailCode, String nickName, String password);

    void updateUserIntegral(Integer userId, UserIntegralOperTypeEnum operTypeEnum, UserIntegralChangeTypeEnum changeTypeEnum, Integer integral);

}
