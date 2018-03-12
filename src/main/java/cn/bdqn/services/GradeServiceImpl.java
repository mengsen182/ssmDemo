package cn.bdqn.services;


import cn.bdqn.dao.GradeMapper;
import cn.bdqn.dao.StudentMapper;
import cn.bdqn.dao.StudentNumMapper;
import cn.bdqn.entity.Grade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5/005.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeMapper gradeMapper;
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentNumMapper studentNumMapper;
    @Override
    public PageInfo<Grade> queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Grade> gradeList=gradeMapper.queryAll();
        return new PageInfo<Grade>(gradeList);
    }

    @Override
    public Grade queryGradeById(Integer gradeId) {
        return gradeMapper.queryGradeById(gradeId);
    }

    @Override
    public Integer deleteGradeById(Integer gradeId) {
        //1. 删除这个班的学生
        studentMapper.deleteStudentByGradeId(gradeId);
        int a=1/0;
        //2. 删除这个班
        return gradeMapper.deleteGradeById(gradeId);
    }

    @Override
    public Integer deleteGradeByIds(List<Integer> ids) {
        return gradeMapper.deleteGradeByIds(ids);
    }

    @Override
    public Integer addGrade(Grade grade) {
        //1. 添加班级
       int n= gradeMapper.addGrade(grade);
        Integer gradeId=grade.getId();
        //2. 添加StudentNum表记录
        studentNumMapper.addStudentNum(gradeId);
        return n;
    }

    @Override
    public Integer updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public List<Grade> queryAll() {
        return gradeMapper.queryAll();
    }

}
