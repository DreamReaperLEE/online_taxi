package heu.iot.Controller.Kefu;

import heu.iot.Controller.WebSecurityConfig;
import heu.iot.Service.EmploeeService;
import heu.iot.Util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/3/31 15:29
 * @Version : 1.0
 */
@RequestMapping("/kefu/info")
@Controller
public class InfoController {
    @Autowired
    private EmploeeService emploeeService;

    @RequestMapping("/showinfo")
    public String showinfo() {
        return "kefu/password";
    }


    @RequestMapping("/changePassword")
    public String changePassword(String inputOrigin, String inputPassword1, String inputPassword2, Model model, HttpSession session) {
        //判断两次密码输入是否一致
        if (!inputPassword2.equals(inputPassword1)) {
            model.addAttribute("fail", "更新失败，新密码两次输入不正确");
            return "kefu/password";
        }
        //将密码转换为md5
        inputOrigin = MD5.getMd5(inputOrigin);
        inputPassword1 = MD5.getMd5(inputPassword1);
        Integer id = Integer.valueOf(session.getAttribute(WebSecurityConfig.ID).toString());
        //判断是否更新成功
        int result = emploeeService.changePassword(id, inputOrigin, inputPassword1);
        if (result == 0)
            model.addAttribute("fail", "更新失败，密码错误");
        else
            model.addAttribute("success", "更新成功");
        return "kefu/password";
    }
}
