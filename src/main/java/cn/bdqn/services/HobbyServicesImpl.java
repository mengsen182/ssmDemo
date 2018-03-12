package cn.bdqn.services;

import cn.bdqn.dao.HobbyMapper;
import cn.bdqn.entity.Hobby;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5/005.
 */
@Service
public class HobbyServicesImpl implements HobbyServices {
    @Resource
    private HobbyMapper hobbyMapper;

    @Override
    public PageInfo<Hobby> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Hobby> list =hobbyMapper.queryAll();
        PageInfo<Hobby> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addHobby(Hobby hobby) {
        return hobbyMapper.addHobby(hobby);
    }

    @Override
    public int deleteHobby(int id) {
        return hobbyMapper.deleteHobby(id);
    }

    @Override
    public int deleteHobbyByIds(List<Integer> ids) {

        return hobbyMapper.deleteHobbyByIds(ids);
    }

    @Override
    public Hobby queryHobbyById(int id) {
        return hobbyMapper.queryHobbyById(id);
    }

    @Override
    public int updateHobbyById(Hobby hobby) {
        return hobbyMapper.updateHobbyById(hobby);
    }
}
