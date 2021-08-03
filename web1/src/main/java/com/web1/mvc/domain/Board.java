package com.web1.mvc.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class Board {

    private int boardSeq;
    private String title;
    private String contents;
//    private Date regDate;
}
