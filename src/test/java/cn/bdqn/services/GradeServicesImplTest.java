package cn.bdqn.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/3/7/007.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GradeServicesImplTest {
    @Resource
    private GradeService gradeServices;
    @Test
    public void queryAll() throws Exception {
    }

    @Test
    public void addGrade() throws Exception {
    }

    @Test
    public void deleteGradeByid() throws Exception {
    }

    @Test
    public void deleteGradeByIds() throws Exception {
    }

    @Test
    public void updateGrade() throws Exception {
    }

    @Test
    public void queryGradeById() throws Exception {
    }

}