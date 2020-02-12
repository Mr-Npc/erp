package pub.npc.soft.erp.service.admin;


import org.springframework.stereotype.Service;
import pub.npc.soft.erp.entity.admin.Menu;

@Service
public interface MenuService {
    public int add(Menu menu);
}
