package cn.bdqn.services;

import cn.bdqn.entity.RoleUser;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public interface RoleUserServlces {
    public RoleUser queryRoleUserByUserNameAndPassword(String userName,String password);

}
