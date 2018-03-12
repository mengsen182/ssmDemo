package cn.bdqn.entity;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public class Menu {
    private  int id,parentId;
    private String menuName,menuUrl;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
