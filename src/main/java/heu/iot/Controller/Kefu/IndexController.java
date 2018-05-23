package heu.iot.Controller.Kefu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sumail-Lee
 * @Version: V1.0.0
 * @Description: 客服端主页
 * @Since: 2017/12/25 9:39
 */
@RequestMapping("/kefu")
@Controller
public class IndexController {

    /**
     * @Author: Sumail-Lee
     * @Description:显示主页
     * @Date: 2018/2/1 13:48
     */
    @RequestMapping("/index")
    public String IndexPage() throws Exception {
        return "kefu/index";
    }


}
