package heu.iot.Dao;

import heu.iot.Model.Emploee;
import heu.iot.Model.EmploeeCar;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EmploeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emploee record);

    int insertSelective(Emploee record);

    Emploee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emploee record);

    int updateByPrimaryKey(Emploee record);

    int updatePassword(@Param("id") Integer id, @Param("origin") String origin, @Param("password") String password);

    Emploee checkPassword(@Param("id") Integer id, @Param("password") String password);

    Emploee drivercheckPassword(@Param("tel") String tel, @Param("password") String password);

    ArrayList<EmploeeCar> showAllDriver();

    ArrayList<EmploeeCar> showSelected(Integer id);

}