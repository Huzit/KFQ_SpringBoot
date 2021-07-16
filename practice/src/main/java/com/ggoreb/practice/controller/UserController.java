package com.ggoreb.practice.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute User user, HttpSession session, Model model) {
        Optional<User> opt = userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());

        if (opt.isPresent()) {
            session.setAttribute("user", opt.get());
            return "redirect:/question/list";
        }else{
            return "signin";
        }
    }

    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
