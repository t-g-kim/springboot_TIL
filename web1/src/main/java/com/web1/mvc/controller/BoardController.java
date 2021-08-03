package com.web1.mvc.controller;

import com.web1.mvc.domain.Board;
import com.web1.mvc.parameter.BoardParameter;
import com.web1.mvc.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "게시판 API")
@AllArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @ApiOperation(value = "게시물 리스트 조회", notes = "게시물 리스트 조회")
    @GetMapping
    public List<Board> getList() {
        return boardService.getList();
    };


    @ApiOperation(value = "게시물 상세 조회", notes = "게시물 상세 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq",  value = "게시물번호", example = "1")
    })
    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {
        return boardService.get(boardSeq);
    };


    @ApiOperation(value = "게시물 등록", notes = "게시물 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq",  value = "게시물번호", example = "1"),
            @ApiImplicitParam(name = "title",  value = "제목", example = "spring"),
            @ApiImplicitParam(name = "contents",  value = "내용", example = "강좌")
    })
    @PostMapping
    public boolean save(@RequestBody BoardParameter boardParameter) {
        return boardService.save(boardParameter);
    };


    @PutMapping
    public void update(@RequestBody BoardParameter boardParameter) {
        System.out.println("Board : " + boardParameter);
        boardService.update(boardParameter);
    };


    public void delete(int boardSeq) {
        boardService.delete(boardSeq);
    };
}
