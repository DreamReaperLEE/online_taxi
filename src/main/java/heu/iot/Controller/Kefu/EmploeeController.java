package heu.iot.Controller.Kefu;

import heu.iot.CeatsApplication;
import heu.iot.Model.*;
import heu.iot.Service.CarService;
import heu.iot.Service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Driver;
import java.util.ArrayList;

/**
 * @Description : 司机管理
 * @Author : reaper
 * @CreateDate : 2018/3/30 16:20
 * @Version : 1.0
 */
@RequestMapping("/kefu/emploee")
@Controller
public class EmploeeController {
    @Autowired
    private EmploeeService emploeeService;
    @Autowired
    private CarService carService;

    //展示所有司机
    @RequestMapping("/showdriver")
    public String showDriver(Model model,@RequestParam(value = "type",defaultValue = "0") Integer type) {
        ArrayList<EmploeeCar> emploeeCars;
        if(type==0){
            emploeeCars=emploeeService.showAllDriver();
        }
        else{
            emploeeCars=emploeeService.showSelected(type);
        }

        ArrayList<Car> cars=carService.showAll();
        model.addAttribute("emploeeCars", emploeeCars);
        model.addAttribute("cars", cars);
        model.addAttribute("type", type);
        return "kefu/emploee";
    }

    //查询所有司机状态
    @RequestMapping("/checkdriver")
    public String checkDriver(Model model) {
        OrderClient orderClient;
        EmploeeCar emploeeCar=new EmploeeCar();
        ArrayList<EmploeeCar> resend=new ArrayList<EmploeeCar>();
        ArrayList<EmploeeCar> emploeeCars=emploeeService.showAllDriver();
        for(EmploeeCar every:emploeeCars){
            if(CeatsApplication.driverMap.containsKey(every.getId())){
                orderClient=CeatsApplication.driverMap.get(every.getId());
                emploeeCar.setEmName(orderClient.getClName());
                emploeeCar.setEmPriv(orderClient.getOrState());
                emploeeCar.setEmPassword(orderClient.getOrTime());
                resend.add(emploeeCar);
            }
            else{
                every.setEmPriv(2);
                every.setEmPassword("无");
                resend.add(every);
            }
        }
        model.addAttribute("resend", resend);

        return "kefu/driveronline";
    }

    /**
     * @Description : 司机信息编辑
     * @Author : reaper
     * @Date : 2018/3/31 11:23
     * @Param :
     * @param model
     */
    @RequestMapping("/driverdetail")
    public String driverdetail(Model model,Integer id) {

        Emploee emploee=emploeeService.selectByPrimaryKey(id);
        ArrayList<Car> cars=carService.showAll();

        model.addAttribute("emploee", emploee);
        model.addAttribute("cars", cars);
        return "kefu/emploeedetail";
    }

    @RequestMapping("/update")
    public String updateDriver(Model model,Emploee emploee) {

        int state=emploeeService.updateByPrimaryKeySelective(emploee);
        if(state==1)
            model.addAttribute("success", "司机信息修改成功!");
        else
            model.addAttribute("fail", "司机信息修改失败!");
        return "redirect:/kefu/emploee/showdriver?type=0";
    }



    @RequestMapping("/driverdelete")
    public String driverdelete(Integer id) {
        emploeeService.deleteByPrimaryKey(id);

        return "redirect:/kefu/emploee/showdriver?type=0";
    }

    @RequestMapping("/adddriver")
    public String adddriver(Emploee emploee) {
        emploeeService.insertSelective(emploee);
        return "redirect:/kefu/emploee/showdriver?type=0";
    }


}
