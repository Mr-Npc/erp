package pub.npc.soft.erp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pub.npc.soft.erp.entity.admin.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * 菜单管理控制器
 */

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("menu/list");
        return modelAndView;
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody  //返回json字符串，不加的话直接查找视图
    public Map<String, String> add(Menu menu){
        Map<String,String> map = new HashMap<String, String>();
        if(menu == null){
            map.put("type","error");
            map.put("msg","请填写正确的菜单名称");
            return map;
        }
        if(StringUtils.isEmpty(menu.getName())){
            map.put("type","error");
            map.put("msg","请填写菜单名称");
            return map;
        }
        if(StringUtils.isEmpty(menu.getIcon())){
            map.put("type","error");
            map.put("msg","请选择菜单图标");
            return map;
        }
        map.put("typr","success");
        map.put("msg","添加成功");

        return map;
    }
}
