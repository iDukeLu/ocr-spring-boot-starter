package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO 描述信息
 *
 * @author idukelu
 * @date 2020/04/27
 */
@Data
@ConfigurationProperties(prefix = "tencent.ocr")
public class TencentOcrProperties {

    /**
     * 访问 腾讯云 所需的 secretId
     */
    private String secretId;

    /**
     * 访问 腾讯云 所需的 secretKey
     */
    private String secretKey;

    /**
     * 区域， 默认：ap-guangzhou
     * 更多可参考：https://cloud.tencent.com/document/product/436/6224#.E4.B8.AD.E5.9B.BD.E5.A4.A7.E9.99.86.E5.9C.B0.E5.9F.9F
     */
    private String region = "ap-guangzhou";

    /**
     * 签名处理版本，目前支持 v1、v2、v3，默认：v3
     */
    private String signatureProcessVersion = "v3";


}




