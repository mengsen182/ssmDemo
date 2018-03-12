package cn.bdqn.controller;

import cn.bdqn.entity.RoleUser;
import cn.bdqn.entity.TUser;
import cn.bdqn.services.RoleUserServlces;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/3/11/011.
 */
@Controller
@RequestMapping("user")
public class LoginController {
    @Resource
    private RoleUserServlces roleUserServlces;

    @RequestMapping(value = "loginByUserNameAndPassword", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String loginByUserNameAndPassword(TUser tUser, HttpSession session, Model model) {
        RoleUser roleUser = roleUserServlces.queryRoleUserByUserNameAndPassword(tUser.getUserName(), tUser.getPassword());
        if (roleUser != null) {
            session.setAttribute("loginUser", roleUser);
            return "main";
        }
        model.addAttribute("message", "用户名或者密码错误");
        return "index1";
    }

}
