package com.criss.wang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.criss.wang.entity.User;

@Controller
//@RestController
public class FilterController {
	@GetMapping("login1")
	public String login1() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("login")
    public String login(String userName,String password,HttpServletRequest request) {
        HttpSession session = request.getSession();

        if("root".equals(userName) && "root".equals(password)) {
            User user = new User();
            user.setUserName(userName);
            session.setAttribute("user",user);
            return "登录成功";
        } else {
            return "用户名或密码错误!";
        }
    }
}
