package pub.npc.soft.erp.dao.admin;


import org.springframework.stereotype.Repository;
import pub.npc.soft.erp.entity.admin.User;
@Repository
public interface UserDao {

    public User  findUserName(String name);

}
