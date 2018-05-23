package heu.iot.Service;

import heu.iot.Dao.EmploeeMapper;
import heu.iot.Model.Emploee;
import heu.iot.Model.EmploeeCar;
import heu.iot.Util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author: Sumail-Lee
 * @Date: 15:18 2017/12/2
 */
@Service("emploeeService")
public class EmploeeService {

    @Autowired
    private EmploeeMapper emploeeMapper;

    private MD5 md5 = new MD5();
    //登陆
    public Emploee login(Integer id,String password){
        password= MD5.getMd5(password);
        Emploee emploee=emploeeMapper.checkPassword(id,password);
        return emploee;
    }

    public Emploee driverlogin(String tel,String password){
        password= MD5.getMd5(password);
        Emploee emploee=emploeeMapper.drivercheckPassword(tel,password);
        return emploee;
    }
    //更换密码
    public int changePassword(Integer id,String origin,String password){
        return emploeeMapper.updatePassword(id,origin,password);
    }
    //所有司机
    public ArrayList<EmploeeCar> showAllDriver(){return emploeeMapper.showAllDriver();}
    //选择的司机
    public ArrayList<EmploeeCar> showSelected(Integer id){return emploeeMapper.showSelected(id);}
    //人员信息
    public Emploee selectByPrimaryKey(Integer id){return emploeeMapper.selectByPrimaryKey(id);}
    //删除人员
    public int deleteByPrimaryKey(Integer id){return emploeeMapper.deleteByPrimaryKey(id);}
    //添加人员
    public int insertSelective(Emploee emploee){
        emploee.setEmPassword(MD5.getMd5("88888888"));
        emploee.setEmPriv(1);
        return emploeeMapper.insertSelective(emploee);
    }
    //修改人员信息
    public int updateByPrimaryKeySelective(Emploee emploee){
        return emploeeMapper.updateByPrimaryKeySelective(emploee);
    }
}
