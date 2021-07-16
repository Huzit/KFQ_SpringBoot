package com.example.board.controller;

import com.example.board.model.User;
import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired HttpSession session;
    //DB저장은 get -> post
    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpPost(@ModelAttribute User user){
        //DB에 저장
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String signIn(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signInPost(@ModelAttribute User user){
        //repo에 선언한 함수
        User dbUser = userRepository.findByEmailAndPwd(user.getEmail(), user.getPwd());
        if(dbUser != null){
            //세션에 user데이터 넣어줌
            session.setAttribute("user", dbUser);
            return "redirect:/";
        }
        return "/signin";
    }

    @GetMapping("/signout")
    public String signOut(){
        //세선 무효화
            session.invalidate();
        return "redirect:/";
    }
}
