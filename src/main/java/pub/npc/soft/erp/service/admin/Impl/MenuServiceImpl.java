package pub.npc.soft.erp.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.npc.soft.erp.dao.admin.MenuDao;
import pub.npc.soft.erp.entity.admin.Menu;
import pub.npc.soft.erp.service.admin.MenuService;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Override
    public int add(Menu menu){
        return menuDao.add(menu);
    }

    @Override
    public List<Menu> findList(Map<String, Object> queryMap) {
        return menuDao.findList(queryMap);
    }
}
