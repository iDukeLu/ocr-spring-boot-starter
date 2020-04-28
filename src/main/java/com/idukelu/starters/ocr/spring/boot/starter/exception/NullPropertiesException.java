package com.idukelu.starters.ocr.spring.boot.starter.exception;

/**
 * 空属性异常
 *
 * @author idukelu
 * @date 2020/04/20
 */
public class NullPropertiesException extends IllegalArgumentException{

    public NullPropertiesException(String properties) {
        super((properties == null ? "Properties" : "Properties: " + properties) + " must not be null.");
    }
}
