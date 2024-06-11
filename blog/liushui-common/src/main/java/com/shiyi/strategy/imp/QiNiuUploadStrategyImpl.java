package com.shiyi.strategy.imp;

import com.shiyi.entity.SystemConfig;
import com.shiyi.service.SystemConfigService;
import com.shiyi.strategy.FileUploadStrategy;
import com.shiyi.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageProperties;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.FileStorageServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.Collections;


@Service("qiNiuUploadStrategyImpl")
@RequiredArgsConstructor
public class QiNiuUploadStrategyImpl implements FileUploadStrategy  {

    private final Logger logger = LoggerFactory.getLogger(QiNiuUploadStrategyImpl.class);

    private final SystemConfigService systemConfigService;

    private final FileStorageService service;


    private final String platform = "qiniu-1";

    private String baseUrl;

    @PostConstruct
    private void init(){
        SystemConfig systemConfig = systemConfigService.getCustomizeOne();

        FileStorageProperties.QiniuKodoConfig config = new FileStorageProperties.QiniuKodoConfig();
        config.setPlatform(platform);
        config.setAccessKey(systemConfig.getQiNiuAccessKey());
        config.setSecretKey(systemConfig.getQiNiuSecretKey());
        config.setDomain(systemConfig.getQiNiuPictureBaseUrl());
        config.setBucketName(systemConfig.getQiNiuBucket());

        service.getFileStorageList().addAll(FileStorageServiceBuilder.buildQiniuKodoFileStorage(Collections.singletonList(config),null));

        baseUrl = systemConfig.getQiNiuPictureBaseUrl();
        logger.info("------初始化七牛云上传配置文件成功-----");
    }


    @Override
    public String fileUpload(MultipartFile file,String suffix) {
        String path = DateUtil.dateTimeToStr(DateUtil.getNowDate(), DateUtil.YYYYMMDD)  + "/";
        return service.of(file).setPath(path).setPlatform(platform).setSaveFilename(file.getOriginalFilename()).upload().getUrl();
    }


    /**
     * 批量删除文件
     * @return
     */
    @Override
    public Boolean deleteFile(String ...keys) {
        for (String key : keys) {
            String[] str = key.split(baseUrl);
            FileInfo fileInfo = new FileInfo()
                    .setPlatform(platform)
                    .setFilename(str[1]);
            service.delete(fileInfo);
        }
        return true;
    }
}
