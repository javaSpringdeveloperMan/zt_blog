package com.shiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiyi.common.ResponseResult;
import com.shiyi.entity.ExceptionLog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-11-11
 */
public interface ExceptionLogService extends IService<ExceptionLog> {

    /**
     * 分页
     * @return
     */
    ResponseResult selectExceptionLogPage();

    /**
     * 删除
     * @param ids
     * @return
     */
    ResponseResult deleteExceptionLog(List<Long> ids);
}
