package cn.bdqn.entity;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public class RoleUser {
    private  Integer id;
    private  Role role;
    private TUser tUser;

    @Override
    public String toString() {
        return "RoleUser{" +
                "id=" + id +
                ", role=" + role +
                ", tUser=" + tUser +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }
}
