package com.example.AtosTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.AtosTest.controller..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("Méthode appelé: {}", joinPoint.getSignature());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));



        long start = System.currentTimeMillis();
        try{
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();

            log.info("Resultat: {}", result);
            log.info("Temps d exécution: {} ms", (end - start)) ;

            return result;
        }catch (Exception e){
            long end = System.currentTimeMillis();

              log.error("Exception : {}", e.getMessage());
              log.info("Temps d exécution: {} ms", (end - start)) ;

            throw e;
        }
    }
}