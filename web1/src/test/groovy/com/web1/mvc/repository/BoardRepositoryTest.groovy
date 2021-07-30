package com.web1.mvc.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class BoardRepositoryTest extends Specification{

    def "첫 테스트" () {
        given:
        int i = 1;
        expect:
        i==1
    }
//
    @Autowired
    private BoardRepository boardRepository;

    def "getList 테스트" () {
        given:
        def boardList = boardRepository.getList()
        when:
        boardList.get(0).getBoardSeq() == 1
        then:
        print(boardList)

    }
}
