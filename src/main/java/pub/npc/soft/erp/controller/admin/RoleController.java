package pub.npc.soft.erp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pub.npc.soft.erp.entity.admin.Role;
import pub.npc.soft.erp.page.admin.Page;
import pub.npc.soft.erp.service.admin.RoleService;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    public RoleService roleService;

    /**
     * 角色列表
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/role/list");
        return modelAndView;
    }

    /**
     * 获取角色列表
     * @param page
     * @param name
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(Page page,
                                       @RequestParam(name="name",required=false,defaultValue="") String name
    ){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        map.put("rows", roleService.findList(queryMap));
        map.put("total", roleService.getTotal(queryMap));
        return map;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Role role){
        Map<String,String> map = new HashMap<String, String>();
        if(role == null){
            map.put("type","error");
            map.put("msg","请填写正确的角色");
            return map;
        }
        if(StringUtils.isEmpty(role.getName())){
            map.put("type","error");
            map.put("msg","请填写正确的角色名称");
            return map;
        }
        if(roleService.add(role) <= 0){
            map.put("type","error");
            map.put("msg","角色添加失败，请联系管理员");
            return map;
        }
        map.put("type","success");
        map.put("msg","角色添加成功");
        return map;
    }

}
