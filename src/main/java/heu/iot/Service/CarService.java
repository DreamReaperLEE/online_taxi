package heu.iot.Service;

import heu.iot.Dao.CarMapper;
import heu.iot.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/3/31 9:10
 * @Version : 1.0
 */
@Service("carService")
public class CarService {
    @Autowired
    private CarMapper carMapper;

    public ArrayList<Car> showAll(){return carMapper.showAll();}

    public int deleteByPrimaryKey(Integer id){return carMapper.deleteByPrimaryKey(id);}

    public int insertSelective(Car car){return carMapper.insertSelective(car);}
}
