package com.codegym.concern;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.CustomerService.findAll(..))")

    public void error(){
        System.out.println("[CMS] ERROR!");
    }
}
