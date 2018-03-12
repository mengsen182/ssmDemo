package cn.bdqn.services;

import cn.bdqn.dao.ScoreMapper;
import cn.bdqn.entity.Course;
import cn.bdqn.entity.Score;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jnlp.ServiceManager;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7/007.
 */
@Service
public class ScoreServicesImpl implements ScoreServices {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public PageInfo<Score> queryAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score> list = scoreMapper.queryAll();
        PageInfo<Score> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Score> queryScore(Integer pageNum, Integer pageSize, Integer gradeId, Integer studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Score> list = scoreMapper.queryScore(gradeId, studentId);
        PageInfo<Score> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Score queryScoreById(Integer id) {
        return scoreMapper.queryScoreById(id);
    }

    @Override
    public int deleteScoreById(Integer id) {
        return scoreMapper.deleteScoreById(id);
    }

    @Override
    public int addScore(Score score) {
        return scoreMapper.addScore(score);
    }

    @Override
    public int updateScore(Score score) {
        return scoreMapper.updateScore(score);
    }


}
