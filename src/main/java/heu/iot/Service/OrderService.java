package heu.iot.Service;

import com.google.gson.Gson;
import heu.iot.CeatsApplication;
import heu.iot.Dao.OrderMapper;
import heu.iot.Model.Order;
import heu.iot.Model.OrderClient;
import heu.iot.Server.KeepAliveNode;
import heu.iot.Util.MyJson;
import heu.iot.Util.TimeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jboss.netty.channel.Channel;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/2 10:34
 * @Version : 1.0
 */
@Service("orderService")
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;


    public int setOrder(Order order){
        order.setOrState(0);
        order.setOrCheck(0);

        Channel channel=CeatsApplication.chanalMap.get(order.getOrEid());
        orderMapper.insertSelective(order);
        if(channel!=null){
            KeepAliveNode keepAliveNode=new KeepAliveNode();
            keepAliveNode.setType("getorder");
            ArrayList<OrderClient> orderClients=orderMapper.selectOrderClientByEmploeeIdRecent1(order.getOrEid());
            keepAliveNode.setObject(new Gson().toJson(orderClients));
            System.out.println("=========="+ MyJson.toJson(keepAliveNode));
            channel.write(MyJson.toJson(keepAliveNode));
        }
        return 1;
    }

    public ArrayList<OrderClient> showAllOrderClient(){
        return orderMapper.showAllOrderClient();
    }

    public ArrayList<OrderClient> selectUncheckOrderClient(){
        return orderMapper.selectUncheckOrderClient();
    }

    public ArrayList<OrderClient> selectOrderClientByCompanyId(Integer id){
        return orderMapper.selectOrderClientByCompanyId(id);
    }

    public ArrayList<OrderClient> selectOrderClientByEmploeeId(Integer id){
        return orderMapper.selectOrderClientByEmploeeId(id);
    }

    public ArrayList<OrderClient> selectOrderClientByEmploeeIdRecent1(Integer id){
        return orderMapper.selectOrderClientByEmploeeIdRecent1(id);
    }

    public ArrayList<OrderClient> selectOrderClientByOrderId(Integer id){
        return orderMapper.selectOrderClientByOrderId(id);
    }

    public int deleteByPrimaryKey(Integer id){
        return orderMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Order order){
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public int updateOrderState(Integer id,Integer state){
        Order order=new Order();
        order.setId(id);
        order.setOrState(state);
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
