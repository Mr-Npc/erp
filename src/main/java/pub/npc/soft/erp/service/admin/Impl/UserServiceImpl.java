package pub.npc.soft.erp.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.npc.soft.erp.dao.admin.UserDao;
import pub.npc.soft.erp.entity.admin.User;
import pub.npc.soft.erp.service.admin.UserService;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    public UserDao userDao;
    @Override
    public User findUserName(String name){

        return userDao. findUserName(name);
    }

}
