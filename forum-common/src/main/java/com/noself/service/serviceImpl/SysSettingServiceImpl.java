package com.noself.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.noself.entity.dto.SysSettingDto;
import com.noself.entity.enums.SysSettingCodeEnum;
import com.noself.entity.po.EmailCode;
import com.noself.entity.po.SysSetting;
import com.noself.mapper.EmailCodeMapper;
import com.noself.mapper.SysSettingMapper;
import com.noself.service.SysSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noself.utils.JsonUtils;
import com.noself.utils.StringTools;
import com.noself.utils.SysCacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
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
                String jsonContent = sysSetting.getJsonContent();
                if (StringTools.isEmpty(jsonContent)) {
                    continue;
                }
                String code = sysSetting.getCode();
                SysSettingCodeEnum sysSettingCodeEnum = SysSettingCodeEnum.getByCode(code);
                // 根据code值实现在设置类中的映射
                PropertyDescriptor pd = new PropertyDescriptor(sysSettingCodeEnum.getPropName(), SysSettingDto.class);
                Method method = pd.getWriteMethod();
                Class subClass = Class.forName(sysSettingCodeEnum.getClassZ());
                method.invoke(sysSettingDto, JsonUtils.covertJson2Obj(jsonContent, subClass));
            }
            // 缓存设置信息
            SysCacheUtils.refresh(sysSettingDto);
        }catch (Exception e) {
            logger.error("刷新缓存失败" + e);
        }
    }
}
