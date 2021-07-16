package com.ggoreb.practice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.QuestionRepository;

@Controller
public class    QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/question/list")
    public String question(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Page<Question> p = questionRepository.findAll(
                PageRequest.of(page - 1, 10, Sort.Direction.DESC, "createDate"));

        List<Question> list = p.getContent();


        model.addAttribute("list", list);
        return "question_list";
    }

    @GetMapping("/question/create")
    public String questionCreate() {
        return "question_create";
    }

    @PostMapping("/question/create")
    public String questionCreatePost(@ModelAttribute Question question, HttpSession session) {
        User user = (User) session.getAttribute("user");
        question.setUser(user);
        question.setCreateDate(new Date());
        questionRepository.save(question);
        return "redirect:/question/list";
    }

    @GetMapping("/question/detail")
    public String questionDetail(Model model, Long id, HttpSession session) {
        Optional<Question> opt = questionRepository.findById(id);
        Question question = opt.get();
        //mappedBy 를 사용한 방법
        List<Answer> answerList = question.getAnswerList();
        if (opt.isPresent()) {
            model.addAttribute("question", question);
            //repository로 호출하는 방법
//            model.addAttribute("answerList", answerRepository.findAllByQuestion(question));
            if(!answerList.isEmpty())
                model.addAttribute("answerList", answerList);
//            session.setAttribute("question", question);
        }
        return "question_detail";
    }
}