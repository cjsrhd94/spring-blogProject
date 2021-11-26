package com.kim.controller;

import com.kim.domain.UserVO;
import com.kim.service.BlogService;
import com.kim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/loginView.do")
    public String loginView() {
        return "login";

    }

    @RequestMapping("/login.do")
    public String login(UserVO vo, HttpSession session, Model model) {
        UserVO user = userService.login(vo);

        if (user != null) {
            session.setAttribute("user", user);
            if (blogService.getUserBlog(user) == null) {
                return "forward:index.do";
            } else {
                model.addAttribute("blog", blogService.getUserBlog(user));
                return "forward:/index.do";
            }
        } else {
            return "forward:/index.do";
        }
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "forward:/";
    }
}
