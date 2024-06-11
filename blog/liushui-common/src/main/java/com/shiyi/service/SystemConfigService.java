package com.shiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiyi.common.ResponseResult;
import com.shiyi.entity.SystemConfig;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author blue
 * @since 2021-11-25
 */
public interface SystemConfigService extends IService<SystemConfig> {

    /**
     * 获取系统配置
     * @return
     */
    ResponseResult getSystemConfig();

    /**
     * 修改
     * @param systemConfig
     * @return
     */
    ResponseResult updateSystemConfig(SystemConfig systemConfig);

    /**
     *
     * @return
     */
    SystemConfig getCustomizeOne();
}
