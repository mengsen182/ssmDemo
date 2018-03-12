package cn.bdqn.dao;


import cn.bdqn.entity.Grade;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5/005.
 */
public interface GradeMapper {
    public List<Grade> queryAll();

    public Grade queryGradeById(Integer gradeId);
    public Integer deleteGradeById(Integer gradeId);

    public Integer deleteGradeByIds(List<Integer> ids);

    public Integer addGrade(Grade grade);

    public Integer updateGrade(Grade grade);


}
