package com.example.aoptraining.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class MethodExecutionTimeAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(TrackTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            logger.info("Execution time is {}", System.currentTimeMillis() - startTime);
            return proceed;
        } catch (Exception e) {
            logger.warn("Exception: " + e.getMessage());
        }
        return joinPoint;
    }
}
