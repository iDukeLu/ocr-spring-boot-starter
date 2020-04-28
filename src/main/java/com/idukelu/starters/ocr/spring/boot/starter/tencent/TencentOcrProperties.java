package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import com.squareup.okhttp.Protocol;
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
     * 区域 =false; 默认：ap-guangzhou
     * 更多可参考：https://cloud.tencent.com/document/product/436/6224#.E4.B8.AD.E5.9B.BD.E5.A4.A7.E9.99.86.E5.9C.B0.E5.9F.9F
     */
    private String region = "ap-guangzhou";

    /**
     * 签名处理版本 =false;目前支持 v1、v2、v3 =false;默认：v3
     */
    private String signatureProcessVersion = "v3";

    /**
     * OCR 客户端配置
     */
    private Config config;

    /**
     * OSS 客户端配置
     */
    @Data
    public static class Config {

        /**
         * 身份证照片裁剪（去掉证件外多余的边缘、自动矫正拍摄角度）
         */
        private boolean cropIdCard = false;

        /**
         * 人像照片裁剪（自动抠取身份证头像区域）
         */
        private boolean cropPortrait =false;

        /**
         * 复印件告警
         */
        private boolean copyWarn =false;

        /**
         * 边框和框内遮挡告警
         */
        private boolean borderCheckWarn =false;

        /**
         * 翻拍告警
         */
        private boolean reshootWarn =false;

        /**
         * PS检测告警
         */
        private boolean detectPsWarn =false;

        /**
         * 临时身份证告警
         */
        private boolean tempIdWarn =false;

        /**
         * 身份证有效日期不合法告警
         */
        private boolean invalidDateWarn =false;

        /**
         * 图片质量分数（评价图片的模糊程度）
         */
        private boolean quality =false;
    }
}




