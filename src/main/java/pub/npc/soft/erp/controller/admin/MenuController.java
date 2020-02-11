package pub.npc.soft.erp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 菜单管理控制器
 */

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("menu/list");
        return modelAndView;
    }
}
