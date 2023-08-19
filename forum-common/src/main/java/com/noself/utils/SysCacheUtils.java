package com.noself.utils;

import com.noself.entity.dto.SysSettingDto;

import java.util.HashMap;
import java.util.Map;

/**
 * 用线程变量缓存设置
 */
public class SysCacheUtils {

    // 系统设置key
    private static final String key = "sys_setting";
    private static final Map<String,SysSettingDto> sysCache = new HashMap<>();

    public static SysSettingDto getSysCache() {
        return sysCache.get(key);
    }

    public static void refresh(SysSettingDto sysSettingDto) {
        sysCache.put(key, sysSettingDto);
    }
}
