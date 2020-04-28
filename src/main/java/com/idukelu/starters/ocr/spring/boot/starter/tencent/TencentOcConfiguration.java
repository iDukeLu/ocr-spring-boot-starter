package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import com.idukelu.starters.ocr.spring.boot.starter.exception.NullPropertiesException;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author idukelu
 * @date 2020/04/28
 */
@Configuration
public class TencentOcConfiguration {

    @Autowired
    @Qualifier("tencentCredential")
    Credential credential;

    @Autowired
    @Qualifier("tencentClientProfile")
    ClientProfile clientProfile;

    @Autowired
    TencentOcrProperties properties;

    @Bean("tencentOcrClient")
    public OcrClient ocrClient() {
        String region = properties.getRegion();
        if (StringUtils.isBlank(region)) {
            throw new NullPropertiesException(region);
        }
        return new OcrClient(credential, region, clientProfile);
    }
}




