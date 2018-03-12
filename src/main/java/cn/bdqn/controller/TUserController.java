package cn.bdqn.controller;

import cn.bdqn.entity.Menu;
import cn.bdqn.entity.TUser;
import cn.bdqn.services.RoleMeunServices;
import cn.bdqn.services.TUserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/3/4/004.
 */
@Controller
@RequestMapping("user")
public class TUserController {
    @Resource
    private TUserServices tUserServices;
    @Resource
    private RoleMeunServices roleMeunServices;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TUser tUser, HttpSession session, Model model) {
        if (tUserServices.login(tUser) != null) {
            session.setAttribute("loginUser", tUserServices.login(tUser));
            return "main";
        }else{
            model.addAttribute("message", "用户名或者密码错误");
            return "index1";
        }
    }
        @ResponseBody
    @RequestMapping(value = "queryMenuByRoleIdAndParentId", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public List<Menu> queryMenuByRoleIdAndParentId(int roleId, int parentId ) {
        return roleMeunServices.queryMenuByRole(roleId, parentId);
    }
}
