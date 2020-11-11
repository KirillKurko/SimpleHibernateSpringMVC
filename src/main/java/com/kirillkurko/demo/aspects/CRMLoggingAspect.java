package com.kirillkurko.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    @Pointcut("execution(* com.kirillkurko.demo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.kirillkurko.demo.model.services.*.*(..))")
    private void forServicesPackage() {}

    @Pointcut("execution(* com.kirillkurko.demo.model.DAO.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicesPackage() || forDAOPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method: " + method);
        Object[] arguments = joinPoint.getArgs();
        for (Object argument: arguments) {
            logger.info("===> argument: " + argument);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @AfterReturning: from method: " + method);
        logger.info("===> result: " + result);
    }
}
