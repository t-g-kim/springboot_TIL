package org.springframework.samples.petclinic.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleControllerTest {

	@Autowired
	ApplicationContext applicationContext;

	// ApplicationContext에 sampleController가 bean으로 등록이 되어있는지 테스트코드 작성
	// SampleController를 componentScan을 통해서 bean등록을 했다
	@Test
	public void testDI() {
		SampleController bean = applicationContext.getBean(SampleController.class);
		assertThat(bean).isNotNull();
	}

}
