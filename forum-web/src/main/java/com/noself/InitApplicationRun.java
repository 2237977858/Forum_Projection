package com.noself;

import com.noself.service.SysSettingService;
import com.sun.glass.ui.Application;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InitApplicationRun implements ApplicationRunner {

    @Resource
    private SysSettingService sysSettingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sysSettingService.refreshCache();
    }
}
