package cn.bdqn.services;

import cn.bdqn.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9/009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceImplTest {
    @Resource
    private StudentService studentService;

    @Test
    public void queryStudentByGradeId() throws Exception {
        List<Student> list = studentService.queryStudentByGradeId(2);
        for (Student student : list) {
            System.out.println(student);
        }
    }

}