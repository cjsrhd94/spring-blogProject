package com.kim.controller;

import com.kim.domain.UserVO;
import com.kim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginView.do")
    public String loginView() {
        return "login";

    }

    @RequestMapping("/login.do")
    public String login(UserVO vo, HttpSession session) {
        UserVO user = userService.login(vo);

        if (user != null) {
            session.setAttribute("user", user);
            return "forward:/";
        } else {
            return "forward:/";
        }
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:/";
    }
}
