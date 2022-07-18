//package com.til.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;
//
//@Component // Bean으로 등록이 되어야 하기때문에
//@Aspect //Aspect 이다
//public class LogAspect {
//    Logger logger = LoggerFactory.getLogger(LogAspect.class);
//    @Around("@annotation(LogExcutionTime)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        // joinPoint는 @LogexcutionTime이라는 어노테이션이 붙어있는 메소드이다.(타겟)
//        // joinPoint라는 인터페이스 타입으로 들어온다.
//
//        StopWatch stopWatch = new StopWatch(); stopWatch.start();
//        Object proceed = joinPoint.proceed(); stopWatch.stop();
//        logger.info(stopWatch.prettyPrint()); return proceed;
//    }
//}
