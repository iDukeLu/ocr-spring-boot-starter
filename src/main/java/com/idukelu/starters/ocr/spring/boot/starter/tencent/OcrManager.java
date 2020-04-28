package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONStringer;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.util.Base64;

/**
 * @author idukelu
 * @date 2020/04/27
 */
@Slf4j
@Component
public class OcrManager {

    private static OcrClient ocrClient;

    private static TencentOcrProperties ocrProperties;

    private static Gson gson = new GsonBuilder().create();

    @Autowired
    @Qualifier("tencentOcrClient")
    public void setOcrClient(OcrClient ocrClient) {
        OcrManager.ocrClient = ocrClient;
    }

    @Autowired
    public void setOcrProperties(TencentOcrProperties ocrProperties) {
        OcrManager.ocrProperties = ocrProperties;
    }

    public static IDCardOCRResponse idCardOcr(byte[] image, String cardSide) {
        // 实例化一个请求对象
        IDCardOCRRequest request = new IDCardOCRRequest();
        request.setCardSide(cardSide);
        request.setImageBase64(Base64Utils.encodeToString(image));
//        request.setConfig(gson.toJson(ocrProperties.getConfig()));
        try{
            // 通过 client 对象调用想要访问的接口，需要传入请求对象
            return ocrClient.IDCardOCR(request);
        } catch (TencentCloudSDKException e) {
            log.error("身份证 OCR 识别异常！", e);
        }
        return null;
    }

    public static IDCardOCRResponse idCardOcr(String imageUrl, String cardSide) {
        // 实例化一个请求对象
        IDCardOCRRequest request = new IDCardOCRRequest();
        request.setCardSide(cardSide);
        request.setImageUrl(imageUrl);
        request.setConfig(gson.toJson(ocrProperties.getConfig()));
        try{
            // 通过 client 对象调用想要访问的接口，需要传入请求对象
            return ocrClient.IDCardOCR(request);
        } catch (TencentCloudSDKException e) {
            log.error("身份证 OCR 识别异常！", e);
        }
        return null;
    }
}




