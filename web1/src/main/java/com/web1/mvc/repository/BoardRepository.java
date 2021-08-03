package com.web1.mvc.repository;

import com.web1.mvc.domain.Board;
import com.web1.mvc.parameter.BoardParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(BoardParameter boardParameter);

    void update(BoardParameter boardParameter);

    void delete(int boardSeq);
}
