package com.web1.mvc.controller;

import com.web1.mvc.domain.Board;
import com.web1.mvc.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @GetMapping
    public List<Board> getList() {
        return boardService.getList();
    };


    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {
        return boardService.get(boardSeq);
    };


    @PostMapping
    public int save(@RequestBody Board board) {
        return boardService.save(board);
    };


    @PutMapping
    public void update(@RequestBody Board board) {
        System.out.println("Board : " + board);
        boardService.update(board);
    };


    public void delete(int boardSeq) {
        boardService.delete(boardSeq);
    };
}
