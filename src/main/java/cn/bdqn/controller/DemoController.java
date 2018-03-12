package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/5/005.
 */
@Controller
@RequestMapping("demo")
public class DemoController {
    @RequestMapping("datagridDemo")
    public String toDemo() {
        return "demo";
    }
}
