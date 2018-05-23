package heu.iot.Dao;

import heu.iot.Model.Car;

import java.util.ArrayList;

public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    ArrayList<Car> showAll();
}