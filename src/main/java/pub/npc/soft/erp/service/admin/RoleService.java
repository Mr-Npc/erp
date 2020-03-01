package pub.npc.soft.erp.service.admin;

import org.springframework.stereotype.Service;
import pub.npc.soft.erp.entity.admin.Role;

@Service
public interface RoleService {
    public int add(Role role);
    public int edit(Role role);
    public int delete(int id);
}
