package com.xm.controller.frontdesk;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.xm.dao.verificationCodeMapper;
import com.xm.pojo.verificationcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @description
 * @author: Specime
 * @date:2020/4/13
 */
@Controller
public class ShortMessageController {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI4FumTFVrUjgqyLZ5AMcV";
    static final String accessKeySecret = "q6IfjQGLLfROaPqzgYWpzJOjGnbuwW";

    @Autowired
    private verificationCodeMapper verificationCodeMapper;

    @RequestMapping("/getSsm")
    public String getSsm(String number) {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //随机生成六位验证码
        int code = (int) ((Math.random() * 9 + 1) * 100000);

        System.out.println(number);
        //查询该有的库，号码不能重复注册
        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("phone", number);
        List<verificationcode> phone = verificationCodeMapper.selectByMap(map);*/

        //删除该号码上次的验证码记录
        verificationCodeMapper.deletePhone(number);

        verificationcode verificationCode = new verificationcode();
        verificationCode.setCode(code + "");
        verificationCode.setPhone(number);
        //保存到数据库
        int i = verificationCodeMapper.insert(verificationCode);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(number);
        //必填:短信签名-可在短信控制台中找到，你在签名管理里的内容
        request.setSignName("小米有品");
        //必填:短信模板-可在短信控制台中找到，你模板管理里的模板编号
        request.setTemplateCode("SMS_187755835");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //获取发送状态
        String cod = sendSmsResponse.getCode();
        return cod;
    }

}
