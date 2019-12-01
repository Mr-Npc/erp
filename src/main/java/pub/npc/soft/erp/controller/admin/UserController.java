package pub.npc.soft.erp.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pub.npc.soft.erp.entity.admin.User;
import pub.npc.soft.erp.service.admin.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/system")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("/system/index");
        return modelAndView;
    }
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView){
        modelAndView.setViewName("/system/welcome");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
            modelAndView.setViewName("/system/login");
            return modelAndView;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> loginAct(User user,HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        if(user == null){
            map.put("type","error");
            map.put("msg","请填写用户信息");
            return map;
        }
        User findUserByname = userService.findUserName(user.getName());
        if(findUserByname == null){
            map.put("type","error");
            map.put("msg","该用户不存在");
            return map;
        }
        if(!user.getPassword().equals(findUserByname.getPassword())){
            map.put("type","error");
            map.put("msg","密码错误");
            return map;
        }
        map.put("type","success");
        map.put("msg","登录成功");
        return map;
    }

}
