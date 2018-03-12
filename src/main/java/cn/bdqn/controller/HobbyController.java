package cn.bdqn.controller;

import cn.bdqn.entity.Hobby;
import cn.bdqn.services.HobbyServices;
import cn.bdqn.util.Message;
import cn.bdqn.util.PageUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/4/004.
 */
@Controller
@RequestMapping("hobby")
public class HobbyController {
    @Resource
    private HobbyServices hobbyServices;
    @RequestMapping("toHobby")
    public String toHobby() {
        return "hobby";
    }

    @ResponseBody
    @RequestMapping(value = "queryHobbyList", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryAll(int page, int rows) {
       PageInfo<Hobby> pageInfo = hobbyServices.queryAll(page, rows);
        PageUtil<Hobby> pageUtil = new PageUtil<>(pageInfo);
        return JSON.toJSONString(pageUtil);
    }

    @ResponseBody
    @RequestMapping(value = "addHobby", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addHobby(Hobby hobby) {
        int n = hobbyServices.addHobby(hobby);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }else{
            return JSON.toJSONString(Message.error());
        }
    }

    @ResponseBody
    @RequestMapping(value = "deleteHobby", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deleteHobby(int id) {
        int n = hobbyServices.deleteHobby(id);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteHobbyByIds", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deleteHobbyByIds(String ids) {
        String[] id = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (id != null) {
            for (String s : id) {
                list.add(Integer.parseInt(s));
            }
            int n = hobbyServices.deleteHobbyByIds(list);
            if (n > 0) {
                return JSON.toJSONString(Message.success());
            }
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "queryHobbyById", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public String queryHobbyById(int id) {
        return JSON.toJSONString(hobbyServices.queryHobbyById(id));
    }

    @ResponseBody
    @RequestMapping(value = "updateHobbyById", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String updateHobby(Hobby hobby) {
        int n = hobbyServices.updateHobbyById(hobby);
        if (n > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.error());
    }
}
