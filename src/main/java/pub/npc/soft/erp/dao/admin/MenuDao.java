package pub.npc.soft.erp.dao.admin;

import org.springframework.stereotype.Repository;
import pub.npc.soft.erp.entity.admin.Menu;

/**
 * 菜单管理Dao
 */
@Repository
public interface MenuDao {
    public int add(Menu menu);
}
