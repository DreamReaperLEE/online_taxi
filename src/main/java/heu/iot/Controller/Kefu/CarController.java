package heu.iot.Controller.Kefu;

import heu.iot.Model.Car;
import heu.iot.Model.Emploee;
import heu.iot.Model.EmploeeCar;
import heu.iot.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@RequestMapping("/kefu/car")
@Controller
public class CarController {
    @Autowired
    private CarService carService;

    //展示所有车型
    @RequestMapping("/showcar")
    public String showCar(Model model) {
        ArrayList<Car> cars=carService.showAll();
        model.addAttribute("cars", cars);
        return "kefu/car";
    }

    @RequestMapping("/cardelete")
    public String carDelete(Integer id) {
        carService.deleteByPrimaryKey(id);
        return "redirect:/kefu/car/showcar";
    }

    @RequestMapping("/addcar")
    public String addCar(String name) {
        Car car=new Car();
        car.setCaType(name);
        carService.insertSelective(car);
        return "redirect:/kefu/car/showcar";
    }
}
