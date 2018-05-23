package heu.iot.Util;


import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/7 10:35
 * @Version : 1.0
 */
public class Message {


    static final String accessKeyId = "23350504";
    static final String accessKeySecret = "c76e5171f55fdc4dc16d22829b34b256";
    static final String url = "http://gw.api.taobao.com/router/rest";

    public static void sendToDrivr(String name,String tel,String date,String start,String end,String send_tel) {
        String msg=String.format("{\"name\":\"%s\",\"tel\":\"%s\",\"date\":\"%s\",\"start\":\"%s\",\"end\":\"%s\"}",name,tel,date,start,end);
        sendmsg(msg,send_tel,"SMS_130840208");
    }

    public static void sendToClient(String name,String tel,String date,String start,String end,String dtel,String send_tel) {
        String msg=String.format("{\"name\":\"%s\",\"tel\":\"%s\",\"date\":\"%s\",\"start\":\"%s\",\"end\":\"%s\",\"driver\":\"%s\"}",name,tel,date,start,end,dtel);
        sendmsg(msg,send_tel,"SMS_130830248");
    }

    public static void sendmsg(String msg,String send_tel,String sms_template) {
        TaobaoClient client = new DefaultTaobaoClient(url, accessKeyId, accessKeySecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("约车系统");
        System.out.println(msg);
        req.setSmsParamString(msg);
        System.out.println(msg);
        req.setRecNum(send_tel);
        req.setSmsTemplateCode(sms_template);
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
    }

}
