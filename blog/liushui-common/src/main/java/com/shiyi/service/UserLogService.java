package com.shiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiyi.common.ResponseResult;
import com.shiyi.entity.UserLog;

import java.util.List;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author blue
 * @since 2021-11-09
 */
public interface UserLogService extends IService<UserLog> {

    /**
     * 分页
     * @return
     */
    ResponseResult selectUserLogPage();

    /**
     * 删除
     * @param ids
     * @return
     */
    ResponseResult deleteUserLog(List<Long> ids);
}
