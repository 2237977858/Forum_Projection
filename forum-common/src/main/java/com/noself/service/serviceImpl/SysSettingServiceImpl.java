package com.noself.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.noself.entity.dto.SysSettingDto;
import com.noself.entity.po.SysSetting;
import com.noself.mapper.SysSettingMapper;
import com.noself.service.SysSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统设置信息 服务实现类
 * </p>
 *
 * @author noself
 * @since 2023年06月10日
 */
@Service
public class SysSettingServiceImpl extends ServiceImpl<SysSettingMapper, SysSetting> implements SysSettingService {

    private static final Logger logger = LoggerFactory.getLogger(SysSettingServiceImpl.class);

    @Resource
    private SysSettingMapper sysSettingMapper;

    /**
     * 读取设置
     */
    @Override
    public void refreshCache() {
        try {
            SysSettingDto sysSettingDto = new SysSettingDto();
            List<SysSetting> list = sysSettingMapper.selectList(null);
            for (SysSetting sysSetting : list) {
               // 将数据库中的字段转成对象存储

            }

        }catch (Exception e) {
            logger.error("刷新缓存失败" + e);
        }
    }
}
