package org.springframework.samples.petclinic.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // bean 설정 파일을 이용한 bean정의
public class SampleConfig {

	@Bean
	public SampleController sampleController() {
		return new SampleController(); // 이 객체 자체가 IOC안에 Bean으로 등록된다.
	}

}
