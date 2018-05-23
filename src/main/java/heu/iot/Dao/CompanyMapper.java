package heu.iot.Dao;

import heu.iot.Model.Company;

import java.util.ArrayList;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    ArrayList<Company> showall();
}