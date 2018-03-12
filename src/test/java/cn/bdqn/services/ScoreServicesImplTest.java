package cn.bdqn.services;

import cn.bdqn.entity.Score;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8/008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ScoreServicesImplTest {
    @Test
    public void deleteScoreById() throws Exception {
        int n = scoreServices.deleteScoreById(6);
        if (n > 0) {
            System.out.println(n);
        }
    }

    @Test
    public void queryScoreById() throws Exception {
        Score score = scoreServices.queryScoreById(1);
        System.out.println(score);

    }

    @Resource
    private ScoreServices scoreServices;
    @Test
    public void queryScore() throws Exception {
        PageInfo<Score> pageInfo = scoreServices.queryScore(1, 6, null, null);
        List<Score> list = pageInfo.getList();
        for (Score score : list) {
            System.out.println(score);
        }
    }

}