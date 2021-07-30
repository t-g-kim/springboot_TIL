package com.web1.mvc

import com.web1.mvc.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpockStudyTest extends Specification {

    @Autowired
    BoardRepository boardRepository

    static final PI = 3.141592

    // Helper Method
    def genString(number) {
        return number
    }

    def "Field Test"() {
        given:
        def list = boardRepository.getList();
        int number = 1
        String str = "Hello"

        when:
        number == 1

        then:
        print(list)
        print("\n" + number)
        print("\n" + str)
        print("\n" + PI)
        print("\nhelper Method 호출 ==> " + genString(1))
    }


    def "feature methods test"() {
        given:
        String hello = "안녕"
        def str = " backend개발1팀"

        when:
        def result = "안녕 backend개발1팀"

        then:
        result == "안녕 backend개발1팀"
    }


    def "given 테스트" () {
        given://  아래 기술 내용은 given 블록임을 지정
        def stack = new Stack()
        def hi = "push me"
        String hello = "hello"
    }

    def "when-then 조건 테스트" () {
        given:
        def stack = new Stack()
        def hi = "push me"
        String hello = "hello"

        when:
        stack.push(hi)

        then:
        stack.first() == "push me"
        stack.size() == 1
//        stack.peek() == hi
        stack.peek() == hello
    }


    def "when-then Exception 테스트" () {
        given:
        def stack = new Stack()

        when:
        stack.pop()

        then:
        thrown(EmptyStackException)
        print(stack.empty)
        stack.empty
    }


    def "when-then Exception 테스트2" () {
        given:
        def stack = new Stack()

        when:
        stack.pop()
        stack.pop()
        stack.pop()

        then:
        EmptyStackException e = thrown()
        print(e.cause) // <=
        e.cause == null
    }


    def "cleanup 테스트"() {
        given:
        def file = new File("/Users/we/Desktop")
        file.createNewFile()

        cleanup:
        file.delete()
    }

    def "where 테스트"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }
}
