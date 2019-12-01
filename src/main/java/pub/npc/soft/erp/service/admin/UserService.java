package pub.npc.soft.erp.service.admin;

import org.springframework.stereotype.Service;
import pub.npc.soft.erp.entity.admin.User;

@Service
public interface UserService {

    public User  findUserName(String name);
}
