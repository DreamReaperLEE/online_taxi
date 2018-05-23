package heu.iot.Controller.Kefu;

import heu.iot.Model.Client;
import heu.iot.Model.Company;
import heu.iot.Service.ClientService;
import heu.iot.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @Description :集团管理
 * @Author : reaper
 * @CreateDate : 2018/3/30 10:44
 * @Version : 1.0
 */
@RequestMapping("/kefu/company")
@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ClientService clientService;

    //展示所有集团
    @RequestMapping("/showcompany")
    public String showCompany(Model model) {
        ArrayList<Company> companies= companyService.showall();

        model.addAttribute("companies", companies);
        return "kefu/company";
    }

    /**
     * @Description : 添加集团
     * @Author : reaper
     * @Date : 2018/3/30 11:01
     * @Param :
     * @param model
     * @param company
     */
    @RequestMapping("/addcompany")
    public String addCompany(Model model,Company company) {

        int state=companyService.insertSelective(company);
        if(state==1)
            model.addAttribute("success", "创建集团成功!");
        else
            model.addAttribute("fail", "创建集团失败!");
        ArrayList<Company> companies= companyService.showall();
        model.addAttribute("companies", companies);
        return "kefu/company";
    }

    /**
     * @Description : 删除集团
     * @Author : reaper
     * @Date : 2018/3/30 16:16
     * @Param :
     * @param model
     * @param id 集团ID
     */
    @RequestMapping("/delete")
    public String deleteCompany(Model model,Integer id) {

        int state=companyService.deleteByPrimaryKey(id);
        if(state==1)
            model.addAttribute("success", "删除集团成功!");
        else
            model.addAttribute("fail", "删除集团失败!");
        ArrayList<Company> companies= companyService.showall();
        model.addAttribute("companies", companies);
        return "kefu/company";
    }

    /**
     * @Description : 集团详细信息
     * @Author : reaper
     * @Date : 2018/3/30 16:17
     * @Param :
     * @param model
     * @param id 集团ID
     */
    @RequestMapping("/detail")
    public String detailCompany(Model model,Integer id) {

        Company company=companyService.selectByPrimaryKey(id);

        model.addAttribute("company", company);
        return "kefu/companydetail";
    }

    /**
     * @Description : 更新集团详细信息
     * @Author : reaper
     * @Date : 2018/3/30 16:17
     * @Param :
     * @param model
     * @param company 集团详细信息
     */
    @RequestMapping("/update")
    public String updateCompany(Model model,Company company) {

        int state=companyService.updateByPrimaryKeySelective(company);
        if(state==1)
            model.addAttribute("success", "修改集团成功!");
        else
            model.addAttribute("fail", "修改集团失败!");
        ArrayList<Company> companies= companyService.showall();
        model.addAttribute("companies", companies);
        return "kefu/company";
    }

    /**
     * @Description : 集团员工信息
     * @Author : reaper
     * @Date : 2018/3/30 16:17
     * @Param :
     * @param model
     * @param id 集团ID
     */
    @RequestMapping("/client")
    public String clientCompany(Model model,Integer id) {

        Company company=companyService.selectByPrimaryKey(id);
        ArrayList<Client> clients=clientService.selectByCompanyId(company.getId());

        model.addAttribute("clients", clients);
        model.addAttribute("company", company);

        return "kefu/companyclient";
    }


    /**
     * @Description : 删除员工
     * @Author : reaper
     * @Date : 2018/3/30 16:18
     * @Param :
     * @param model
     * @param id 员工ID
     * @param cid 集团ID
     */
    @RequestMapping("/deleteclient")
    public String deleteClient(Model model,Integer id,Integer cid) {

        int state=clientService.deleteByPrimaryKey(id);

        return "redirect:/kefu/company/client?id="+cid;
    }

    /**
     * @Description : 添加员工
     * @Author : reaper
     * @Date : 2018/3/30 16:18
     * @Param :
     * @param model
     * @param client 员工信息
     */
    @RequestMapping("/addclient")
    public String addClient(Model model,Client client) {

        int exist=clientService.clientExist(client.getClTel());
        if(exist==0){
            int state=clientService.insertSelective(client);

            if(state==1)
                model.addAttribute("success", "添加员工成功!");
            else
                model.addAttribute("fail", "添加员工失败!");
        }
        else {
            model.addAttribute("fail", "已经存在相同手机号用户!");
        }

        Company company=companyService.selectByPrimaryKey(client.getClCompany());
        ArrayList<Client> clients=clientService.selectByCompanyId(company.getId());

        model.addAttribute("clients", clients);
        model.addAttribute("company", company);
        return "kefu/companyclient";
    }



}
