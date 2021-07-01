package com.web1.mvc.repository;

import com.web1.mvc.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(Board board);

    void update(Board board);

    void delete(int boardSeq);
}
