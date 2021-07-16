package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.board.email.Mailer;
import com.example.board.email.SMTPAuthenticator;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String contact() {
        return "contact/contact";
    }

    @PostMapping("/contact")
    @ResponseBody
    public String contactPost(String email, String comment) {
        Mailer mailer = new Mailer();
        mailer.sendMail(
                "hwan4789@gmail.com", "문의내용 : " + email,
                comment, new SMTPAuthenticator());
        return "ok";
    }
}