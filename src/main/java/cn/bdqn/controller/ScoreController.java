package cn.bdqn.controller;

import cn.bdqn.entity.Score;
import cn.bdqn.services.CourseServices;
import cn.bdqn.services.ScoreServices;
import cn.bdqn.util.Message;
import cn.bdqn.util.PageUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/3/4/004.
 */
@Controller
@RequestMapping("score")
public class ScoreController {
    @Resource
    private ScoreServices scoreServices;
    @Resource
    private CourseServices courseServices;

    @RequestMapping("toScore")
    public String toScore() {
        return "score";
    }

    @ResponseBody
    @RequestMapping(value = "queryScore", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAll(Integer page, Integer rows, Integer gradeId, Integer studentId) {
        if (gradeId != null && gradeId == -1) {
            gradeId = null;
        }
        if (studentId != null && studentId == -1) {
            studentId = null;
        }
        PageInfo<Score> pageInfo = scoreServices.queryScore(page, rows, gradeId, studentId);
        PageUtil<Score> pageUtil = new PageUtil<>(pageInfo);
        String json = JSON.toJSONString(pageUtil);
        System.out.println(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "queryScoreById", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryScoreById(Integer id) {
        Score score = scoreServices.queryScoreById(id);
        return JSON.toJSONString(score);
    }

    @ResponseBody
    @RequestMapping(value = "deleteScoreById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deleteScoreById(Integer id) {
        int n = scoreServices.deleteScoreById(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryCourse", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})

    public String queryCourse() {
        return JSON.toJSONString(courseServices.queryCourse());
    }

    @ResponseBody
    @RequestMapping(value = "addScore", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addScore(Score score) {
        int n = scoreServices.addScore(score);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "updateScore", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateScore(Score score) {
        int n = scoreServices.updateScore(score);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
    }
