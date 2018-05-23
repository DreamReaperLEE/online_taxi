package heu.iot.Dao;

import heu.iot.Model.Order;
import heu.iot.Model.OrderClient;

import java.util.ArrayList;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    ArrayList<OrderClient> showAllOrderClient();

    ArrayList<OrderClient> selectUncheckOrderClient();

    ArrayList<OrderClient> selectOrderClientByCompanyId(Integer id);

    ArrayList<OrderClient> selectOrderClientByEmploeeId(Integer id);

    ArrayList<OrderClient> selectOrderClientByEmploeeIdRecent1(Integer id);

    ArrayList<OrderClient> selectOrderClientByOrderId(Integer id);
}