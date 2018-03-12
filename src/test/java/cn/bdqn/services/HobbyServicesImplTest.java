package cn.bdqn.services;

import cn.bdqn.entity.Hobby;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5/005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HobbyServicesImplTest {
    @Test
    public void addHobby() throws Exception {
        Hobby hobby =new Hobby();
        hobby.setHobbyName("你好");
        int n = hobbyServices.addHobby(hobby);
        System.out.println(n);
    }

    @Test
    public void deleteHobby() throws Exception {
        int n = hobbyServices.deleteHobby(38);
        if (n > 0) {
            System.out.println(n);
        }
    }

    @Test
    public void deleteHobbyByIds() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(33);
        int n = hobbyServices.deleteHobbyByIds(list);
        if (n > 0) {
            System.out.println(n);
        }
    }

    @Resource
    private HobbyServices hobbyServices;

    @Test
    public void queryAll() throws Exception {
        PageInfo<Hobby> pageInfo = hobbyServices.queryAll(1, 3);
        List<Hobby> list = pageInfo.getList();
        for (Hobby hobby : list) {
            System.out.println(hobby);
        }
    }

}