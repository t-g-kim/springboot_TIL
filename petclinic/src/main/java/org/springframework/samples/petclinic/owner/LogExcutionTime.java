package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어노테이션을 어디에 사용할 수 있는지
@Retention(RetentionPolicy.RUNTIME) // 언제까지 유지할것인가. 런타임까지 유지한다.
public @interface LogExcutionTime {

}
