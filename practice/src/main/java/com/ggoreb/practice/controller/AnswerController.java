package com.ggoreb.practice.controller;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.AnswerRepository;
import com.ggoreb.practice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@Controller
public class AnswerController {
    @Autowired AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/answer/create")
    public String answerCreate(@RequestParam("content") String content, HttpSession session, @RequestParam("q_id") Long qId){
        Answer answer = new Answer();
        //세션에 넣는 방식 QuestionController.questionDetail 에서 세션 받아옴
        Question question = (Question)session.getAttribute("question");
        //모델에서 가져오는 방식
        Optional<Question> opt = questionRepository.findById(qId);
        User user = (User)session.getAttribute("user");
        //로그인검증
        if(user==null){
            return "/signin";
        }
//        answer.setQuestion(question);
        answer.setQuestion(opt.get());
        answer.setContent(content);
        answer.setCreateDate(new Date());
        answer.setUser(user);
        answerRepository.save(answer);
        return "redirect:/question/list";
    }
}
