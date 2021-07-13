package com.cloud.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cloud.basic.model.User;

@Controller
public class SessionController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(User user, HttpSession session) {
        session.setAttribute("user", user);
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @Autowired
    HttpSession session;

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        //완전히 삭제
        session.invalidate();
        return "redirect:/main";
    }
}