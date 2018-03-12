package cn.bdqn.services;


import cn.bdqn.entity.Grade;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5/005.
 */
public interface GradeService {
    public PageInfo<Grade> queryAll
            (Integer pageNum, Integer pageSize);

    public Grade queryGradeById(Integer gradeId);
    public Integer deleteGradeById(Integer gradeId);
    public Integer deleteGradeByIds(List<Integer> ids);
    public Integer addGrade(Grade grade);
    public Integer updateGrade(Grade grade);

    public List<Grade> queryAll();
}
