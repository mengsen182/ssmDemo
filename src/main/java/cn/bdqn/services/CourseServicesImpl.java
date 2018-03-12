package cn.bdqn.services;

import cn.bdqn.dao.CourseMapper;
import cn.bdqn.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9/009.
 */
@Service
public class CourseServicesImpl implements CourseServices {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> queryCourse() {
        return courseMapper.queryCourse();
    }
}
