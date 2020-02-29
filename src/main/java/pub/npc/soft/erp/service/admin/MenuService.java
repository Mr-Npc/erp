package pub.npc.soft.erp.service.admin;


import org.springframework.stereotype.Service;
import pub.npc.soft.erp.entity.admin.Menu;

import java.util.List;
import java.util.Map;

@Service
public interface MenuService {
    public int add(Menu menu);
    public List<Menu> findList(Map<String,Object> queryMap);
}
