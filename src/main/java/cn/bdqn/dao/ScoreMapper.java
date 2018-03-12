package cn.bdqn.dao;

import cn.bdqn.entity.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7/007.
 */
public interface ScoreMapper {
    public List<Score> queryAll();

    List<Score> queryScore(@Param("gradeId") Integer gradeId, @Param("studentId") Integer studentId);

    public Score queryScoreById(Integer id);

    public int deleteScoreById(Integer id);

    int addScore(Score score);

    int updateScore(Score score);
}
