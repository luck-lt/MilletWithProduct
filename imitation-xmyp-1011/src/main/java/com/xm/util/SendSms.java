package com.xm.util;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xm.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@Component
public class SendSms {
    @Autowired
    private SmsUtil smsUtil;

    /*    @JmsListener(destination = "sms")*/

    public void sendSms(Map<String, String> map) {
        try {
            SendSmsResponse response = smsUtil.sendSms(
                    map.get("mobile"),
                    map.get("template_code"),//模板编号
                    map.get("sign_name"),//签名
                    map.get("param")  //短信内容
            );
            System.out.println("code" + response.getCode());
            System.out.println("Message" + response.getMessage());
            System.out.println("RequestId" + response.getRequestId());
            System.out.println("BizId" + response.getBizId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}