package pub.npc.soft.erp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pub.npc.soft.erp.entity.admin.Menu;
import pub.npc.soft.erp.page.admin.Page;
import pub.npc.soft.erp.service.admin.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理控制器
 */

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单列表页
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("menu/list");
        return modelAndView;
    }
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> getMenuList(Page page, @RequestParam(name = "name",required = false,defaultValue = "")String name){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        queryMap.put("name", name);
        List<Menu> findList = menuService.findList(queryMap);
        map.put("rows", findList);
        map.put("total", menuService.getTotal(queryMap));

        return map;
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
        //判断新增父类菜单ID是否为空，如果为空，则将ID更改为-1
       if(menu.getParentId() == null){
           menu.setParentId(-1l);
       }

        //判断菜单数量是否增加，如果小于等于0的情况下则提示
        if(menuService.add(menu) <= 0){
            map.put("type","error");
            map.put("msg","添加失败，请联系管理员");
            return map;
        }
        map.put("type","success");
        map.put("msg","添加成功");
        return map;
    }

    /**
     * 菜单修改
     * @param menu
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(Menu menu){
        Map<String, String> map = new HashMap<String, String>();
        if(menu == null){
            map.put("type", "error");
            map.put("msg", "请选择正确的菜单信息!");
            return map;
        }
        if(StringUtils.isEmpty(menu.getName())){
            map.put("type", "error");
            map.put("msg", "请填写菜单名称!");
            return map;
        }
        if(StringUtils.isEmpty(menu.getIcon())){
            map.put("type", "error");
            map.put("msg", "请填写菜单图标类!");
            return map;
        }
        if(menu.getParentId() == null){
            menu.setParentId(0l);
        }
        if(menuService.edit(menu) <= 0){
            map.put("type", "error");
            map.put("msg", "修改失败，请联系管理员!");
            return map;
        }
        map.put("type", "success");
        map.put("msg", "修改成功!");
        return map;
    }

    /**
     * 删除菜单信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(
            @RequestParam(name="id",required=true) Long id
    ){
        Map<String, String> map = new HashMap<String, String>();
        if(id == null){
            map.put("type", "error");
            map.put("msg", "请选择要删除的菜单信息!");
            return map;
        }
        List<Menu> findChildernList = menuService.findChildernList(id);
        if(findChildernList != null && findChildernList.size() > 0){
            //表示该分类下存在子分类，不能删除
            map.put("type", "error");
            map.put("msg", "该分类下存在子分类，不能删除!");
            return map;
        }
        if(menuService.delete(id) <= 0){
            map.put("type", "error");
            map.put("msg", "删除失败，请联系管理员!");
            return map;
        }
        map.put("type", "success");
        map.put("msg", "删除成功!");
        return map;
    }
}
