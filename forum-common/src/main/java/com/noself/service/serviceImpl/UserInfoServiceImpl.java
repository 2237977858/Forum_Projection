package com.noself.service.serviceImpl;

import com.noself.entity.UserInfo;
import com.noself.mapper.UserInfoMapper;
import com.noself.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
