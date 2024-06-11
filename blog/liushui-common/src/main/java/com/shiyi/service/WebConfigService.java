package com.shiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiyi.common.ResponseResult;
import com.shiyi.entity.WebConfig;

/**
 * <p>
 * 网站配置表 服务类
 * </p>
 *
 * @author blue
 * @since 2021-11-27
 */
public interface WebConfigService extends IService<WebConfig> {

    /**
     * 获取网站配置详情
     * @return
     */
    ResponseResult getWebConfig();

    /**
     * 修改
     * @param webConfig
     * @return
     */
    ResponseResult updateWebConfig(WebConfig webConfig);
}