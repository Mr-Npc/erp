package pub.npc.soft.erp.dao.admin;


import org.springframework.stereotype.Repository;
import pub.npc.soft.erp.entity.admin.Role;

import java.util.List;
import java.util.Map;

/**
 * 角色DAO接口
 */
@Repository
public interface RoleDao {

    public int add(Role role);
    public int edit(Role role);
    public int delete(int id);
    public List<Role> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public Role find(Long id);
}
