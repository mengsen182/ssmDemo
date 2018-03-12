package cn.bdqn.services;

import cn.bdqn.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public interface RoleMeunServices {
    List<Menu> queryMenuByRole(int roleId, int parentId);

}
