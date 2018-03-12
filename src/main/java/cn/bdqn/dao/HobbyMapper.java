package cn.bdqn.dao;

import cn.bdqn.entity.Hobby;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5/005.
 */
public interface HobbyMapper {
    public List<Hobby> queryAll();

    int addHobby(Hobby hobby);

    int deleteHobby(int id);

    int deleteHobbyByIds(List<Integer> ids);

    public Hobby queryHobbyById(int id);

    public int updateHobbyById(Hobby hobby);
}
