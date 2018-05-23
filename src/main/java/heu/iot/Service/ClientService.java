package heu.iot.Service;

import heu.iot.Dao.ClientMapper;
import heu.iot.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/3/30 14:20
 * @Version : 1.0
 */
@Service("clientService")
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    public ArrayList<Client> selectByCompanyId(Integer id){
        return clientMapper.selectByCompanyId(id);
    }

    public int deleteByPrimaryKey(Integer id){return clientMapper.deleteByPrimaryKey(id);}

    public int insertSelective(Client client){return clientMapper.insertSelective(client);}

    public int clientExist(String tel){return clientMapper.clientExist(tel);}

    public Client selectByTel(String tel){return clientMapper.selectByTel(tel);}

    public Client selectByPrimaryKey(Integer id){return clientMapper.selectByPrimaryKey(id);}
}
