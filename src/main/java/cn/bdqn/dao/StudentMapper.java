package cn.bdqn.dao;


import cn.bdqn.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/2/27/027.
 */
public interface StudentMapper {
    public List<Student> queryAll();

    public Integer deleteStudentByIds(List<Integer> ids);

    public Integer addStudent(Student student);

    public Student queryStudentById(Integer id);

    public Integer updateStudent(Student student);

    public Integer deleteStudentByGradeId(Integer gradeId);

    public List<Student> queryStudentByGradeId(int gradeId);
}
