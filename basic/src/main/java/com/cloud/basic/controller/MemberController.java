package com.cloud.basic.controller;

import com.cloud.basic.model.Member;
import com.cloud.basic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member")
    public String member(){
        return "member";
    }

    @PostMapping("/member")
    public String memberPost(@ModelAttribute Member member, Model model){
        memberRepository.save(member);
        model.addAttribute("member", member.getUserid());
        return "member";
    }
}
