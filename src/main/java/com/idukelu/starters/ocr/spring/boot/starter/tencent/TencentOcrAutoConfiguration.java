package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import com.idukelu.starters.ocr.spring.boot.starter.constant.SignatureProcessVersionEnum;
import com.idukelu.starters.ocr.spring.boot.starter.exception.NullPropertiesException;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author idukelu
 * @date 2020/04/27
 */
@Configuration
@EnableConfigurationProperties(TencentOcrProperties.class)
public class TencentOcrAutoConfiguration {

    private static final String PROPERTY_SECRET_ID = "secretId";
    private static final String PROPERTY_SECRET_KEY = "secretKey";
    private static final String PROPERTY_REGION = "region";

    @Bean("tencentCredential")
    @ConditionalOnMissingBean(name = "tencentCredential")
    public Credential credential(TencentOcrProperties properties) {
        String secretId = properties.getSecretId();
        String secretKey = properties.getSecretKey();

        assertPropertiesNotNull(PROPERTY_SECRET_ID, secretId);
        assertPropertiesNotNull(PROPERTY_SECRET_KEY, secretKey);

        return new Credential(secretId, secretKey);
    }

    @Bean("tencentClientProfile")
    @ConditionalOnMissingBean(name = "tencentClientProfile")
    public ClientProfile clientProfile(TencentOcrProperties properties) {
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setSignMethod(SignatureProcessVersionEnum.getEncryption(properties.getSignatureProcessVersion()));
        return clientProfile;
    }

    /**
     * 参数非空校验
     * @param property 属性
     * @param value 属性值
     */
    private void assertPropertiesNotNull(String property, String value) {
        if (StringUtils.isBlank(value)) {
            throw new NullPropertiesException(property);
        }
    }
}




