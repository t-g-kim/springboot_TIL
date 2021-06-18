package com.til.aop;

import org.springframework.stereotype.Component;

@Component
public class Example {

    @LogExcutionTime
    public void test() {
        System.out.println("AOP TEST");
    }
}
