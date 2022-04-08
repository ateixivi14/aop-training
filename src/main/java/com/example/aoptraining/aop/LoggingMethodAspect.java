package com.example.aoptraining.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
@RequiredArgsConstructor
public class LoggingMethodAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;

    @Pointcut("within(com.example.aoptraining.service.ProductService)")
    private void serviceMethods() {}
    
    @Around("serviceMethods()")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method Name: " + signature.getMethod().getName() + " Method class: " + signature.getDeclaringType());
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> logger.info("Method param value: " + o.toString()));

        try {
            Object proceed = joinPoint.proceed();
            logger.info(objectMapper.writeValueAsString(proceed));
            return proceed;
        } catch (Exception e) {
            logger.warn("Exception: " + e.getMessage());
            throw e;
        }
    }
    
}
