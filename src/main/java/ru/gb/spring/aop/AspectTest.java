package ru.gb.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Pointcut("execution(* ru.gb.spring.controller..*.*(..))")
    public void getName() {
    }

    @Before("getName()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }
}
