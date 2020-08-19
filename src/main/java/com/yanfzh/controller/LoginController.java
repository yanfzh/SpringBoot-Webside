package com.yanfzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: spring-boot-webapp
 * @description:登录提交校验
 * @author: Yanfzh
 * @create: 2020-08-11 09:26
 **/
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "1".equals(password)){
            //登录成功，防表单重复提交，重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login";
    }

}
