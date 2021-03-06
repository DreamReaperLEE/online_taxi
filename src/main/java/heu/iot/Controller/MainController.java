package heu.iot.Controller;


import heu.iot.Model.Emploee;
import heu.iot.Service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: Sumail-Lee
 * @Version: V1.0.0
 * @Description:
 * @Since: 2017/12/17 19:22
 */
@Controller
public class MainController {
    //不活动的登陆最长存活时间
    public final static int MAX_ACTIVE_TIME = 30 * 60;

    @Autowired
    private EmploeeService emploeeService;

    //登陆
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //主页
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @param account  账号
     * @param password 密码
     * @param session
     * @Author: Sumail-Lee
     * @Description: 处理登陆请求
     * @Date: 2017/12/17 21:07
     */
    @PostMapping("/loginPost")
    public String loginPost(String account, String password, HttpSession session, Model model) {

        //获取数据库中账号信息
        Emploee emploee = emploeeService.login(Integer.valueOf(account), password);
        if (emploee == null) {
            return "login";
        }
        // 设置session
        session.setAttribute(WebSecurityConfig.ID, account);
        session.setAttribute(WebSecurityConfig.LEVEL, emploee.getEmPriv());
        session.setMaxInactiveInterval(MAX_ACTIVE_TIME);
        if (emploee.getEmPriv() == 0) {
            return "redirect:/kefu/index";
        } else
            return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.ID);
        session.removeAttribute(WebSecurityConfig.LEVEL);
        return "redirect:/login";
    }

}