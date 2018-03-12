package cn.bdqn.services;

import cn.bdqn.entity.Score;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2018/3/7/007.
 */
public interface ScoreServices {
    PageInfo<Score> queryAll(int pageNum, int pageSize);

    PageInfo<Score> queryScore(Integer pageNum, Integer pageSize, Integer gradeId, Integer studentId);
    public Score queryScoreById(Integer id);
    public int deleteScoreById(Integer id);
    int addScore(Score score);
    int updateScore(Score score);

}
