package com.shiyi.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.shiyi.common.Constants;
import com.shiyi.common.ResponseResult;
import com.shiyi.entity.Resource;
import com.shiyi.enums.DataEventEnum;
import com.shiyi.enums.FileUploadModelEnum;
import com.shiyi.event.DataEventPublisherService;
import com.shiyi.exception.BusinessException;
import com.shiyi.service.FileService;
import com.shiyi.service.SystemConfigService;
import com.shiyi.strategy.context.FileUploadStrategyContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final SystemConfigService systemConfigService;

    private final FileUploadStrategyContext fileUploadStrategyContext;

    private FileUploadModelEnum strategy;

    private final DataEventPublisherService dataEventPublisherService;


    /**
     * 上传文件
     * @param file
     * @return
     */
    @Override
    public ResponseResult upload(MultipartFile file) {

        if (file.getSize() > 1024 * 1024 * 10) {
            return ResponseResult.error("文件大小不能大于10M");
        }
        //获取文件后缀
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!Constants.FIELD_SUFFIX.toUpperCase().contains(suffix.toUpperCase())) {
            return ResponseResult.error("请选择jpg,jpeg,gif,png,mp4格式的图片");
        }
        getFileUploadWay();
        String key = fileUploadStrategyContext.executeFileUploadStrategy(strategy.getStrategy(), file, suffix);

        Resource resource = Resource.builder().url(key).type(suffix).platform(strategy.getDesc()).userId(StpUtil.getLoginIdAsString()).build();
        dataEventPublisherService.publishData(DataEventEnum.RESOURCE_ADD,resource);
        return ResponseResult.success(key);
    }


    /**
     * 删除文件
     * @param key
     * @return
     */
    @Override
    public ResponseResult delBatchFile(String ...key) {
        getFileUploadWay();
        Boolean isSuccess = fileUploadStrategyContext.executeDeleteFileStrategy(strategy.getStrategy(), key);
        if (!isSuccess) {
            throw new BusinessException("删除文件失败");
        }
        return ResponseResult.success();
    }

    private void getFileUploadWay() {
        strategy = FileUploadModelEnum.getStrategy(systemConfigService.getCustomizeOne().getFileUploadWay());
    }
}
