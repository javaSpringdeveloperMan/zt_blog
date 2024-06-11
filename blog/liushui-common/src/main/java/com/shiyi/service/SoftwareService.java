package com.shiyi.service;


import com.baomidou.mybatisplus.extension.service.IService;

import com.shiyi.common.ResponseResult;
import com.shiyi.entity.Software;

import java.util.List;


/*
 * @Description:
 * @date: 2024-03-19
 */

public interface SoftwareService  extends IService<Software> {

    /**
     * 查询列表
     */
    ResponseResult selectSoftwareList();

    /**
     * 根据id查询
     */
    ResponseResult selectSoftwareById(Integer id);

    /**
     * 保存
     */
    ResponseResult saveSoftware(Software bSoftware);

    /**
     * 修改
     */
    ResponseResult updateSoftware(Software bSoftware);

    /**
     * 删除
     */
    ResponseResult removeSoftwareByIds(List<Integer> ids);
}
