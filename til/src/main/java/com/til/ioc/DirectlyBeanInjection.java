package com.til.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // bean 설정 파일을 이용한 bean정의
public class DirectlyBeanInjection {

    @Bean
    public AService sampleService() {
        return new AService(); // 이 객체가 IOC안에 bean으로 등록된다.
    }
}
