package heu.iot.Service;

import heu.iot.Dao.CompanyMapper;
import heu.iot.Model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/3/30 10:48
 * @Version : 1.0
 */
@Service("companyService")
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public ArrayList<Company> showall(){
        return companyMapper.showall();
    }

    public int insertSelective(Company company){
        return companyMapper.insertSelective(company);
    }

    public int deleteByPrimaryKey(Integer id){return companyMapper.deleteByPrimaryKey(id);}

    public Company selectByPrimaryKey(Integer id){return companyMapper.selectByPrimaryKey(id);}

    public int updateByPrimaryKeySelective(Company company){return companyMapper.updateByPrimaryKeySelective(company);}
}
