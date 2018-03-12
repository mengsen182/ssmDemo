package cn.bdqn.services;


import cn.bdqn.dao.StudentMapper;
import cn.bdqn.dao.StudentNumMapper;
import cn.bdqn.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/2/27/027.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentNumMapper studentNumMapper;


    @Override
    public PageInfo<Student> queryAll(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Student> list=studentMapper.queryAll();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer deleteStudentByIds(List<Integer> ids) {
        return studentMapper.deleteStudentByIds(ids);
    }

    @Override
    public Integer addStudent(Student student) {
        Integer gradeId=student.getGrade().getId();
        //1. 修改班级的最大学员编号
        studentNumMapper.updateMaxNumByGradeId(gradeId);
        //2. 取出最大学员编号
        int maxNum=studentNumMapper.queryMaxNumByGradeId(gradeId);
        //3. 计算学生编号
        String gradeName=student.getGrade().getGradeName();
        String studentNum=gradeName+maxNum;
        int lenth=15-studentNum.length();
        for(int i=0;i<lenth;i++){
            gradeName=gradeName+0;
        }
        gradeName=gradeName+maxNum;
        //4. 添加学生
        student.setStudentNum(gradeName);
        return studentMapper.addStudent(student);
    }

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.queryStudentById(id);
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> queryStudentByGradeId(int gradeId) {
        return studentMapper.queryStudentByGradeId(gradeId);
    }


}
