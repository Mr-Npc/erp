package pub.npc.soft.erp.service.admin.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pub.npc.soft.erp.dao.admin.RoleDao;
import pub.npc.soft.erp.entity.admin.Role;
import pub.npc.soft.erp.service.admin.RoleService;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleDao roleDao;
    @Override
    public int add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public int edit(Role role) {
        return roleDao.edit(role);
    }

    /**
     * 角色接口实现，角色不能批量删除
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public List<Role> findList(Map<String, Object> queryMap) {
        return roleDao.findList(queryMap);
    }

    @Override
    public int getTotal(Map<String, Object> queryMap) {
        return roleDao.getTotal(queryMap);
    }

    @Override
    public Role find(Long id) {
        return roleDao.find(id);
    }


}
