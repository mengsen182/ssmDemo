package cn.bdqn.controller;

import cn.bdqn.entity.Grade;
import cn.bdqn.entity.Student;
import cn.bdqn.services.GradeService;
import cn.bdqn.services.StudentService;
import cn.bdqn.util.Message;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5/005.
 */
@RequestMapping("student")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    private GradeService gradeService;

    @RequestMapping("toStudent")
    public String toStudent(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Student> pageInfo = studentService.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "student";
    }

    @ResponseBody
    @RequestMapping(value = "deleteStudentByIds",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String deleteStudentByIds(String ids){
        String[] idArray=ids.split(",");
        List<Integer> idList = new ArrayList<>();

        if (null != idArray) {
            for (String s : idArray) {
                idList.add(Integer.parseInt(s));
            }
        }

        int n = studentService.deleteStudentByIds(idList);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addStudent",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String addStudent(Student student){
        int n = studentService.addStudent(student);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }


    @ResponseBody
    @RequestMapping(value = "queryStudentById",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String queryStudentById(Integer studentId){
        Student student = studentService.queryStudentById(studentId);
        return JSON.toJSONString(student);
    }

    @ResponseBody
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String updateStudent(Student student) {
        int n = studentService.updateStudent(student);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryStudentByGradeId", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryStudentByGradeId(Integer gradeId) {
        List<Student> list = studentService.queryStudentByGradeId(gradeId);
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "queryAllGrade", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAll() {
        List<Grade> list = gradeService.queryAll();
        return JSON.toJSONString(list);
    }

}
