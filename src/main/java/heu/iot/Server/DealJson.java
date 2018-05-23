package heu.iot.Server;
import com.google.gson.Gson;
import heu.iot.CeatsApplication;
import heu.iot.Model.Emploee;
import heu.iot.Model.Order;
import heu.iot.Model.OrderClient;
import heu.iot.Service.EmploeeService;
import heu.iot.Service.OrderService;
import heu.iot.Util.MyJson;
import heu.iot.Util.TestUtils;
import heu.iot.Util.TimeFactory;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Test;
import org.jboss.netty.channel.Channel;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/4 9:26
 * @Version : 1.0
 */
public class DealJson {





    private String json;
    private Channel channel;
    private KeepAliveNode keepAliveNode;

    public DealJson(String json, Channel channel) {
        super();
        this.json = json;
        this.channel = channel;
    }

    public void checkJson() {
        String type = null;
        keepAliveNode = MyJson.JsonToKeepAliveNode(json);
        type = keepAliveNode.getType();
        switchByType(type);
    }

    private void switchByType(String type) {
        OrderClient orderClient=new OrderClient();
        Order order=new Order();
        int state;
        switch (type) {
            case "updategps":
                String origin=keepAliveNode.getResult();
                String[] split=origin.split(",");
                Integer id=Integer.valueOf(split[0]);
                String jd=split[1];
                String wd=split[2];
                orderClient.setClName(TestUtils.selectByPrimaryKey(id).getEmName());
                orderClient.setOrEid(id);
                orderClient.setOrSgps(jd);
                orderClient.setOrEgps(wd);
                orderClient.setOrTime(TimeFactory.getCurrentHour());
                CeatsApplication.chanalMap.put(id,channel);
                if(CeatsApplication.driverMap.containsKey(id)){
                    OrderClient temp=CeatsApplication.driverMap.get(id);
                    if(temp.getOrState()==null){
                        orderClient.setOrState(0);
                    }
                    else{
                        orderClient.setOrState(temp.getOrState());
                    }
                }else{
                    orderClient.setOrState(0);
                }
                CeatsApplication.driverMap.put(id,orderClient);
                break;

            case "updateorder":
                orderClient=new Gson().fromJson(keepAliveNode.getObject().toString(),OrderClient.class);
                order.setOrState(orderClient.getOrState());
                order.setId(orderClient.getId());
                state= TestUtils.updateorder(order);
                OrderClient temp= CeatsApplication.driverMap.get(orderClient.getOrEid());
                if(order.getOrState()==1){
                    temp.setOrState(1);
                }else{
                    temp.setOrState(0);
                }
                CeatsApplication.driverMap.put(orderClient.getOrEid(),temp);

                if(state==1){
                    keepAliveNode.setResult("success");
                }
                else{
                    keepAliveNode.setResult("fail");
                }
                CeatsApplication.chanalMap.get(orderClient.getOrEid()).write(MyJson.toJson(keepAliveNode));
                break;
            default:
                break;
        }

    }


}

