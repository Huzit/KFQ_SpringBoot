package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.model.User;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    @Autowired
    HttpSession session;

    @Autowired
    BoardRepository boardRepository;
    //보드 쓰기
    @GetMapping("/board/write")
    public String write(){
        return "board/write";
    }

    @PostMapping("/board/write")
    public String writePost(@ModelAttribute Board board){
        //세션의 유저정보 가져옴
        User user = (User) session.getAttribute("user");
        //이메일을 넣어줌
        board.setUserId(user.getEmail());
        boardRepository.save(board);

        return "board/write";
    }
    //보드 조회
    @GetMapping("/board")
    public String board(Model model){
        List<Board> board = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("list", board);
        return "board/list";
    }
    //보드 상세내용
    @GetMapping("/board/{id}")
    public String boardView(Model model, @PathVariable("id") long id) {
        Optional<Board> data = boardRepository.findById(id);
        Board board = data.get();
        model.addAttribute("board", board);
        return "board/view";
    }

    //보드 업데이트
    @GetMapping("/board/update/{id}")
    public String boardUpdate(Model model, @PathVariable("id") long id){
        //id로 보드정보를 가지고 옴
        Optional<Board> opt = boardRepository.findById(id);
        Board board = opt.get();
        model.addAttribute("board", board);
        return "board/update";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdatePost(@ModelAttribute Board board, @PathVariable("id") long id){
        //보드 데이터는 get에서 가져왔으니 userId, id만 넣어주면 된다.
        User user = (User)session.getAttribute("user");
        board.setUserId(user.getEmail());
        board.setId(id);
        boardRepository.save(board);

        return "redirect:/board/"+id;
    }

    //보드 삭제
    @GetMapping("/board/delete/{id}")
    public String boardDelete(@PathVariable("id") long id){
        boardRepository.deleteById(id);
        return "redirect:/board";
    }
}
