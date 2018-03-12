package cn.bdqn.entity;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public class RoleMenu {
    private  int id;
    private  Role role;
    private  Menu menu;

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", role=" + role +
                ", menu=" + menu +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
