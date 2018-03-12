package cn.bdqn.services;

import cn.bdqn.dao.RoleMeunMapper;
import cn.bdqn.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/11/011.
 */
@Service
public class RoleMeunServicesImpl implements RoleMeunServices {
    @Resource
    private RoleMeunMapper roleMeunMapper;
    @Override
    public List<Menu> queryMenuByRole(int roleId, int parentId) {
        return roleMeunMapper.queryMenuByRole(roleId, parentId);
    }
}
