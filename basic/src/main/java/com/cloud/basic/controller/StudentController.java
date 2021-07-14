package com.cloud.basic.controller;

import com.cloud.basic.model.Student;
import com.cloud.basic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    public String student(){
        return "student";
    }

    @PostMapping("/student")
    public String studentPost(@ModelAttribute Student student){
        studentRepository.save(student);
        return "redirect:/main";
    }
}
