package cn.bdqn.services;

import cn.bdqn.entity.Hobby;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5/005.
 */
public interface HobbyServices {
    public PageInfo<Hobby> queryAll(int pageNum, int pageSize);
    int addHobby(Hobby hobby);
    int deleteHobby(int id);

    int deleteHobbyByIds(List<Integer> ids);
    public Hobby queryHobbyById(int id);

    public int updateHobbyById(Hobby hobby);
}
