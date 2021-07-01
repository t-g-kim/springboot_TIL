package com.web1.mvc.service;

import com.web1.mvc.domain.Board;
import com.web1.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {


    private final BoardRepository boardRepository;

    /**
     * @return
     */
    public List<Board> getList() {
        return boardRepository.getList();
    };

    /**
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq) {
        return boardRepository.get(boardSeq);
    };

    /**
     * @param board
     */
    public int save(Board board) {
        boardRepository.save(board);
        return board.getBoardSeq();
    };

    /**
     * 업데이트 처리
     * @param board
     */
    public void update(Board board) {
        boardRepository.update(board);
    };

    /**
     * 삭제처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        boardRepository.delete(boardSeq);
    };
}
