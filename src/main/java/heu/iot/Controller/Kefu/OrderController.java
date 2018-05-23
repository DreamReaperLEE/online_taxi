package heu.iot.Controller.Kefu;

import heu.iot.CeatsApplication;
import heu.iot.Model.*;
import heu.iot.Service.*;
import heu.iot.Util.Excel;
import heu.iot.Util.Message;
import heu.iot.Util.MyJson;
import heu.iot.Util.OrderExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/1 15:29
 * @Version : 1.0
 */
@RequestMapping("/kefu/order")
@Controller
public class OrderController {
    @Autowired
    private EmploeeService emploeeService;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CompanyService companyService;

    /**
     * @Description :
     * @Author : reaper
     * @Date : 2018/4/3 18:56
     * @Param :  开始订单页面
     * @param model
     */
    @RequestMapping("/startorder")
    public String startorder(Model model) {

        ArrayList<EmploeeCar> emploeeCars=emploeeService.showAllDriver();
        ArrayList<Car> cars=carService.showAll();
        model.addAttribute("cars", cars);
        return "kefu/startorder";
    }

    /**
     * @Description : 验证手机号，是否存在此客户
     * @Author : reaper
     * @Date : 2018/4/3 18:57
     * @Param :
     * @param tel 电话
     */
    @RequestMapping("/checkclient")
    @ResponseBody
    public Map<String,String> checkClient(String tel){

        Map<String,String> map=new HashMap<>();
        if(clientService.clientExist(tel)!=0){
            map.put("exist","true");
            Client client=clientService.selectByTel(tel);
            map.put("name",client.getClName());
            map.put("id",String.valueOf(client.getId()));
        }
        else{
            map.put("exist","false");
        }
        return map;
    }

    /**
     * @Description : 获取价格
     * @Author : reaper
     * @Date : 2018/4/3 18:57
     * @Param :  * @param
     */
    @RequestMapping("/getprice")
    @ResponseBody
    public String getprice(){

        return "12";
    }

    /**
     * @Description : 获取对应车型司机
     * @Author : reaper
     * @Date : 2018/4/3 18:57
     * @Param :
     * @param type 车型
     */
    @RequestMapping("/getdriver")
    @ResponseBody
    public List<EmploeeCar> checkClient(int type){


        ArrayList<EmploeeCar> emploees=emploeeService.showSelected(type);
        return emploees;
    }

    @RequestMapping("/getonline")
    @ResponseBody
    public List<OrderClient> getonline(){
        ArrayList<OrderClient> orderClients=new ArrayList<OrderClient>();
        OrderClient orderClient;
        Iterator it = CeatsApplication.driverMap.keySet().iterator();
        while(it.hasNext()) {
            Integer key = (Integer)it.next();
            orderClient=CeatsApplication.driverMap.get(key);
            if(orderClient.getOrState()!=1){
                orderClients.add(orderClient);
            }
        }
        return orderClients;
    }


    /**
     * @Description : 下订单
     * @Author : reaper
     * @Date : 2018/4/3 18:58
     * @Param :
     * @param order 订单信息
     * @param or_date 订单日期
     */
    @RequestMapping("/setorder")
    public String setorder(Order order,String or_date) {

        System.out.println();
        order.setOrTime(or_date+" "+order.getOrTime());
        orderService.setOrder(order);

        Client client=clientService.selectByPrimaryKey(order.getOrCid());
        Emploee emploee=emploeeService.selectByPrimaryKey(order.getOrEid());
        //给司机发
        Message.sendToDrivr(client.getClName(),client.getClTel(),order.getOrTime(),order.getOrStart(),order.getOrEnd(),emploee.getEmTel());

        //给客户发
        Message.sendToClient(client.getClName(),client.getClTel(),order.getOrTime(),order.getOrStart(),order.getOrEnd(),emploee.getEmTel(),client.getClTel());
        return "kefu/startorder";
    }


    @RequestMapping("/ordermanage")
    public String orderManage(Model model,@RequestParam(value = "companyid",defaultValue = "0") Integer companyid) {
        ArrayList<Company> companies=companyService.showall();
        ArrayList<OrderClient> orderClients;
        if(companyid==0) {
            orderClients = orderService.showAllOrderClient();
        }
        else{
            orderClients=orderService.selectOrderClientByCompanyId(companyid);
        }
        model.addAttribute("companies", companies);
        model.addAttribute("orderClients", orderClients);

        return "kefu/order_manage";
    }

    @RequestMapping("/ordercompanymanage")
    @ResponseBody
    public List<OrderClient> orderCompanyManage(@RequestParam(value = "companyid",defaultValue = "0") Integer companyid) {
        ArrayList<OrderClient> orderClients;
        if(companyid==0) {
            orderClients = orderService.showAllOrderClient();
        }
        else{
            orderClients=orderService.selectOrderClientByCompanyId(companyid);
        }

        return orderClients;
    }

    @RequestMapping("/cancelorder")
    public String cancelOrder(Model model,Integer id) {
        orderService.deleteByPrimaryKey(id);
        return "redirect:/kefu/order/ordermanage";
    }

    @RequestMapping("/orderend")
    public String orderEnd(Model model,Integer id) {
        Order order=new Order();
        order.setId(id);
        order.setOrCheck(1);
        orderService.updateByPrimaryKeySelective(order);
        return "redirect:/kefu/order/ordermanage";
    }

    /**
     * @Author: Sumail-Lee
     * @Description:导出考试信息到Excel
     * @param response
     * @param request
     * @Date: 2018/1/24 10:50
     */
    @RequestMapping("/download")
    @ResponseBody
    public String examExcle(HttpServletResponse response, HttpServletRequest request) throws Exception {
        ArrayList<OrderClient> orderClients=orderService.selectUncheckOrderClient();
        String fineName="OrderList";
        ArrayList<String> title= OrderExcel.getTitle();
        ArrayList<ArrayList<String>> data=OrderExcel.getData(orderClients);
        return Excel.createExcel(fineName,title,data,response);

    }

}
