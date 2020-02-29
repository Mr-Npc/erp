package pub.npc.soft.erp.entity.admin;

import org.springframework.stereotype.Component;

/**
 * 角色实体
 */
@Component
public class Role {
    private int id;//角色ID
    private String name;//角色名称
    private String remark;//角色备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
