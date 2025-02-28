package com.koleso.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // before logging
    @Before("execution(* com.koleso.spring..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Call of method : {}", joinPoint.getSignature().toShortString());
    }

    // successful logging
    @AfterReturning(pointcut = "execution(* com.koleso.spring..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} executed, result: {}", joinPoint.getSignature().toShortString(), result);
    }

    // exceptions logging
    @AfterThrowing(pointcut = "execution(* com.koleso.spring..*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Method {} throws an exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}