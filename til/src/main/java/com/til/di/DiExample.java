package com.til.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiExample {

    // 필드 주입
    @Autowired
    private Aclass aClass;

    //생성자
    private final Bclass bclass;
    public DiExample(Bclass bclass) {
        this.bclass =bclass;
    }


    // setter주입
    private Cclass cClass;
    @Autowired
    public void setCClass(Cclass cClass) {
        this.cClass = cClass;
    }


    public void test() {
        aClass.aTest();
        bclass.bTest();
        cClass.cTest();
    }
}
