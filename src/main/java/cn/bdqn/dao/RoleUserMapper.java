package cn.bdqn.dao;

import cn.bdqn.entity.RoleUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public interface RoleUserMapper {
    public RoleUser queryRoleUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
