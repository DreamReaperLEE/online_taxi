package heu.iot.Util;

import heu.iot.Model.Emploee;
import heu.iot.Model.Order;
import heu.iot.Service.EmploeeService;
import heu.iot.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUtils {

    @Autowired
    private OrderService orderService;
    @Autowired
    private EmploeeService emploeeService;

    public static TestUtils testUtils;
    @PostConstruct
    public void init() {
        testUtils = this;
    }
    public static int updateorder(Order order){
        return testUtils.orderService.updateByPrimaryKeySelective(order);
    }
    public static Emploee selectByPrimaryKey(Integer id){
        return testUtils.emploeeService.selectByPrimaryKey(id);
    }
}
