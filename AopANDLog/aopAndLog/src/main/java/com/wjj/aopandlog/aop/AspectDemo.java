package com.wjj.aopandlog.AOP.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author :wjj
 * @date : 2023/4/3
 * @Description :
 */

@Aspect
@Component
public class AspectDemo {

    @Pointcut("execution(* com.wjj.aopandlog.controller.TestController.test(..))")
    private void controllerMethods(){}

    @Around(value = "execution(* com.wjj.aopandlog.controller.TestController.test(..))")
    public void AroundMethod(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI().toString();
    }


}
