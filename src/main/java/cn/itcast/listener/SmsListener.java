package cn.itcast.listener;

import cn.itcast.util.SendSms2;
import cn.itcast.util.SmsUtil;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {
//    @Autowired
//    private SmsUtil smsUtil;

    @Autowired
    private SendSms2 sendSms2;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String, String> mapMessage) throws Exception {
        if(mapMessage != null){
            sendSms2.sendMessage(mapMessage);
        }
    }
//
//    @JmsListener(destination = "sms")
//    public void sendSms(Map<String, String> mapMessage) throws Exception {
//        SendSmsResponse sendSmsResponse = smsUtil.sendSms(
//                mapMessage.get("phone"),
//                mapMessage.get("signName"),
//                mapMessage.get("templateCode"),
//                mapMessage.get("param"));
//        System.out.println("===getCode===" + sendSmsResponse.getCode());
//        System.out.println("===getMessage===" + sendSmsResponse.getMessage());
//        System.out.println("===getBizId===" + sendSmsResponse.getBizId());
//        System.out.println("===getRequestId===" + sendSmsResponse.getRequestId());
//    }
}
