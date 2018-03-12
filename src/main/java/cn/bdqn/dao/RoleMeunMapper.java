package cn.bdqn.dao;

import cn.bdqn.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/3/11/011.
 */
public interface RoleMeunMapper {
    List<Menu> queryMenuByRole(@Param("roleId")int roleId,@Param("parentId")int parentId);

}
