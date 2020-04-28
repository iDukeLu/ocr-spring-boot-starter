package com.idukelu.starters.ocr.spring.boot.starter.constant;

/**
 * 签名处理版本枚举
 *
 * @author idukelu
 * @date 2020/04/27
 */
public enum SignatureProcessVersionEnum {

    /**
     * 签名处理版本
     */
    V1("v1", "HmacSHA1"),
    V2("v2", "HmacSHA256"),
    V3("v3", "TC3-HMAC-SHA256");

    private String version;

    private String encryption;

    SignatureProcessVersionEnum(String version, String encryption) {
        this.version = version;
        this.encryption = encryption;
    }

    public static String getEncryption(String version) {
        switch (version) {
            case "v1":
                return V1.encryption;
            case "v2":
                return V2.encryption;
            case "v3":
            default:
                return V3.encryption;
        }
    }
}
