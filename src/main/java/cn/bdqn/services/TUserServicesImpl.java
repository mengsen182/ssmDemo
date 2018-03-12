package cn.bdqn.services;

import cn.bdqn.dao.TUserMapper;
import cn.bdqn.entity.TUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/3/4/004.
 */
@Service
public class TUserServicesImpl implements TUserServices {
    @Resource
    private TUserMapper tUserMapper;
    @Override
    public TUser login(TUser tUser) {
        return tUserMapper.login(tUser);
    }
}
