package com.cloud.basic.controller;

import com.cloud.basic.model.Board;
import com.cloud.basic.model.FileAtch;
import com.cloud.basic.repository.BoardRepository;
import com.cloud.basic.repository.FileAtchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
    @Autowired BoardRepository boardRepository;
    @Autowired FileAtchRepository fileAtchRepository;

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @PostMapping("/write")
    @ResponseBody
    public FileAtch writePost(@ModelAttribute Board board, MultipartFile abcd){
        Board dbBoard = boardRepository.save(board);
        FileAtch fileAtch = new FileAtch();

        fileAtch.setBoard(dbBoard);
        fileAtch.setOriginName(abcd.getOriginalFilename());
        fileAtch.setSaveName(abcd.getOriginalFilename());

        FileAtch result = fileAtchRepository.save( fileAtch );

        System.out.println(board);
        System.out.println(abcd.getOriginalFilename());


        return result;
    }
}
