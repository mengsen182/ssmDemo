package cn.bdqn.services;

import cn.bdqn.dao.RoleUserMapper;
import cn.bdqn.entity.RoleUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/3/11/011.
 */
@Service
public class RoleUserServlcesImpl implements RoleUserServlces {
    @Resource
    private RoleUserMapper roleUserMapper;

    @Override
    public RoleUser queryRoleUserByUserNameAndPassword(String userName, String password) {

        return roleUserMapper.queryRoleUserByUserNameAndPassword(userName, password);
    }
}
