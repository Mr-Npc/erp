package pub.npc.soft.erp.entity.admin;

import org.springframework.stereotype.Component;

/**
 * 菜单实体类
 */
@Component
public class Menu {
    private int id;
    private int parentId;//菜单父类ID
    private String name;//菜单名称
    private String url;//菜单地址
    private String icon;//菜单图标


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
