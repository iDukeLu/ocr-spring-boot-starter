package com.idukelu.starters.ocr.spring.boot.starter.annotation;

import com.idukelu.starters.ocr.spring.boot.starter.tencent.OcrManager;
import com.idukelu.starters.ocr.spring.boot.starter.tencent.TencentOcConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author duke
 * @date 2020.04.29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({TencentOcConfiguration.class, OcrManager.class})
public @interface EnableOCR {
}
