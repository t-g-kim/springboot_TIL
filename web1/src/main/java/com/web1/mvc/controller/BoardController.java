package com.web1.mvc.controller;

import com.web1.mvc.domain.Board;
import com.web1.mvc.repository.BoardRepository;
import com.web1.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;


    @GetMapping
    public List<Board> getList() {
        return boardService.getList();
    };


    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {
        return boardService.get(boardSeq);
    };


    public void save(Board board) {
        boardService.save(board);
    };


    public void update(Board board) {
        boardService.update(board);
    };


    public void delete(int boardSeq) {
        boardService.delete(boardSeq);
    };
}
