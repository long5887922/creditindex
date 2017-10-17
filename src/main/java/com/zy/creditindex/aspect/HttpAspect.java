package com.zy.creditindex.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by ${ZhaoYing}on 2017/9/25 0025
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
//       @Before("execution(public * com.zy.creditindex.controller.ControllerCreditIndex.*(..))")
        @Pointcut("execution(public * com.zy.creditindex.controller.ControllerCreditIndex.*(..))")//公共的切点
        public void log(){
//            System.out.println("AOP OPEN 拦截***********");
        }
        @Before("log()")
        public void doBefore(JoinPoint joinpoint){
           ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            logger.info("AOP OPEN 拦截@@@@@@@@@@@@");
            //uil
            logger.info("uil={}",request.getRequestURL());
            //method
            logger.info("method={}",request.getMethod());
            //ip
            logger.info("ip={}",request.getRemoteAddr());
            //类方法
            logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
            //参数
            logger.info("agrs={}",joinpoint.getArgs());
        }
        @After("log()")
        public void doAfter(){
            logger.info("AOP END  拦截***********");
        }
        @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterreturning(Object object){
            logger.info("responese={}",object);
        }

}
