package com.til.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BServiceTest {

    @Autowired
    BService bService;

    @Autowired
    ApplicationContext applicationContext;

    // 직접 부러온 bean과 ComponentScan으로 불러온 bean의 비교
    @Test
    public void testBean() {
        BService bean = applicationContext.getBean(BService.class);
        System.out.println(bean);

        System.out.println(bService);
    }
}
