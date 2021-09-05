package com.til.controllerVsRestController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ExampleRestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestValue() {
        String TestValue = "RestController Test";
        return TestValue;
    }

    @GetMapping("user")
    public List<User> showBoard(Model model) {
        List<User> boards = Arrays.asList(
                new User(1L, "김태균", "01011112222", "용인 기흥구 신갈동"),
                new User(2L, "김태희", "01011113333", "서울시 강남구 삼성동" ),
                new User(3L, "아이유", "01011114444", "성남시 분당구")
        );
        return boards;
    }

}
