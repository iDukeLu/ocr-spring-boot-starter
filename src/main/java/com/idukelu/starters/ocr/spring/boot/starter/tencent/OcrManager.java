package com.idukelu.starters.ocr.spring.boot.starter.tencent;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.util.Base64;

/**
 * @author idukelu
 * @date 2020/04/27
 */
@Component
public class OcrManager {

    private static OcrClient ocrClient;

    @Autowired
    @Qualifier("tencentOcrClient")
    public void setOcrClient(OcrClient ocrClient) {
        OcrManager.ocrClient = ocrClient;
    }


    public static void IDCardOCR(byte[] image, String cardSide) {
        try{
            // 实例化一个请求对象
            IDCardOCRRequest idCardOCRRequest = new IDCardOCRRequest();
            idCardOCRRequest.setCardSide(cardSide);
            idCardOCRRequest.setImageBase64("");

            // 通过client对象调用想要访问的接口，需要传入请求对象
            IDCardOCRResponse response = ocrClient.IDCardOCR(idCardOCRRequest);

            // 输出json格式的字符串回包
            System.out.println(DescribeZonesRequest.toJsonString(response));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }
}




