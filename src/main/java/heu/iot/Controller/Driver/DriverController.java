package heu.iot.Controller.Driver;

import heu.iot.Model.*;
import heu.iot.Server.KeepAliveNode;
import heu.iot.Server.UserNode;
import heu.iot.Service.*;
import heu.iot.Util.MyJson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/1 15:29
 * @Version : 1.0
 */
@RequestMapping("/driver")
@Controller
public class DriverController {
    @Autowired
    private EmploeeService emploeeService;
    @Autowired
    private OrderService orderService;


    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String json) throws JSONException {
        System.out.println("================");
        System.out.println(json);
        Map<String,Object> jsonObject=new HashMap<>();
        ArrayList<OrderClient> orderClients;
        UserNode userNode=MyJson.JsonToUserNode(json);
        Emploee emploee=emploeeService.driverlogin(userNode.getTel(),userNode.getPassword());
        if(emploee==null){
            //keepAliveNode.setResult("false");
            jsonObject.put("result","fail");
        }
        else{
            orderClients=orderService.selectOrderClientByEmploeeId(emploee.getId());
            jsonObject.put("result","success");
            jsonObject.put("name",emploee.getEmName());
            jsonObject.put("id",emploee.getId());
            jsonObject.put("orderlist",orderClients);
        }

        return jsonObject;
    }

    @RequestMapping("/getorder")
    @ResponseBody
    public KeepAliveNode getorder(String json) {
        KeepAliveNode keepAliveNode=MyJson.JsonToKeepAliveNode(json);
        OrderClient origin=(OrderClient)keepAliveNode.getObject();
        ArrayList<OrderClient> orderClient=orderService.selectOrderClientByOrderId(origin.getId());
        keepAliveNode.setObject(orderClient);
        keepAliveNode.setResult("success");
        return keepAliveNode;
    }





}
