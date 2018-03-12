package cn.bdqn.controller;

import cn.bdqn.entity.Grade;
import cn.bdqn.services.GradeService;
import cn.bdqn.util.Message;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
@Controller
@RequestMapping("grade")
public class GradeController {

    @Resource
    private GradeService gradeServices;

    @RequestMapping("toGrade")
    public String toGrade(Integer pageNum,Integer pageSize,Model model) {
        //1.查询班级记录
        PageInfo<Grade> pageInfo=gradeServices.queryAll(pageNum,pageSize);

        //2. 把班级记录返回
        model.addAttribute("pageInfo",pageInfo);
        return "grade";
    }

    @ResponseBody
    @RequestMapping(value = "queryGradeById",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String queryGradeById(Integer gradeId){
        Grade grade = gradeServices.queryGradeById(gradeId);
        return JSON.toJSONString(grade);
    }

    @ResponseBody
    @RequestMapping(value = "deleteGradeById",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String delteGradeById(Integer gradeId){
        int n=gradeServices.deleteGradeById(gradeId);
        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteGareByIds",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String deleteGareByIds(String ids){
        String[] idsArray=ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String s : idsArray) {
            idList.add(Integer.parseInt(s));
        }
        int n=gradeServices.deleteGradeByIds(idList);
        if(n>0){
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "addGrade",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String addGrade(Grade grade) {
        int n=gradeServices.addGrade(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "updateGrade",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String updateGrade(Grade grade) {
        int n = gradeServices.updateGrade(grade);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.GET,
    produces = {"application/json;charset=utf-8"})
    public String queryAll(){
        List<Grade> gradeList=gradeServices.queryAll();
        return JSONArray.toJSONString(gradeList);
    }

}
