package heu.iot.Dao;

import heu.iot.Model.Client;

import java.util.ArrayList;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    ArrayList<Client>  selectByCompanyId(Integer cl_company);

    int clientExist(String cl_tel);

    Client selectByTel(String cl_tel);
}