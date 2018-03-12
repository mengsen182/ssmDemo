package cn.bdqn.services;


import cn.bdqn.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/2/27/027.
 */
public interface StudentService {
    public PageInfo<Student> queryAll(Integer pageNum, Integer pageSize);
    public Integer deleteStudentByIds(List<Integer> ids);
    public Integer addStudent(Student student);
    public Student queryStudentById(Integer id);
    public Integer updateStudent(Student student);
    public List<Student> queryStudentByGradeId(int gradeId);
}
