package pub.npc.soft.erp.service.admin;

import org.springframework.stereotype.Service;
import pub.npc.soft.erp.entity.admin.Role;

import java.util.List;
import java.util.Map;

@Service
public interface RoleService {
    public int add(Role role);
    public int edit(Role role);
    public int delete(int id);
    public List<Role> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public Role find(Long id);

}
