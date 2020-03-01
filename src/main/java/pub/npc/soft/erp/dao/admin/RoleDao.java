package pub.npc.soft.erp.dao.admin;


import org.springframework.stereotype.Repository;
import pub.npc.soft.erp.entity.admin.Role;

/**
 * 角色DAO接口
 */
@Repository
public interface RoleDao {

    public int add(Role role);
    public int edit(Role role);
    public int delete(int id);
}
