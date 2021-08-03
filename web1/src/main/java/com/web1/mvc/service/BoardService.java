package com.web1.mvc.service;

import com.web1.mvc.domain.Board;
import com.web1.mvc.parameter.BoardParameter;
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
     * @param BoardParameter
     */
    public boolean save(BoardParameter boardParameter) {
        boardRepository.save(boardParameter);
        return true;
    };

    /**
     * 업데이트 처리
     * @param BoardParameter
     */
    public void update(BoardParameter boardParameter) {
        boardRepository.update(boardParameter);
    };

    /**
     * 삭제처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        boardRepository.delete(boardSeq);
    };
}
