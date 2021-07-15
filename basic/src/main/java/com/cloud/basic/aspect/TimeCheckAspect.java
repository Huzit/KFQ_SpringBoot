package com.cloud.basic.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeCheckAspect {
    static long currentTime = 0;

    @Before(value = "execution (* com.cloud.basic.controller.ThymeleafController.userList(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {
//        currentTime = System.currentTimeMillis();
    }

    @After(value = "execution (* com.cloud.basic.controller.*.*(..))")
    public void onAfterHandler(JoinPoint joinPoint) {
//        System.out.println(System.currentTimeMillis()-currentTime);
    }

}