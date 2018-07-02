package com.news.util;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {
	private static Logger logger=Logger.getLogger(LoggerAspect.class);
	
	@Before("execution(* com.news.service..*.*(..))")
	public void before(JoinPoint jp){
		logger.info("进入了前置增强，调用了"+jp.getTarget()+"类的，"+jp.getSignature().getName()+"方法，参数是："+Arrays.toString(jp.getArgs()));
	}
	@AfterReturning(pointcut="execution(* com.news.service..*.*(..))",returning="result")
	public void afterReturning(JoinPoint jp,Object result){
		logger.info("进入了后置增强，调用了"+jp.getTarget()+"类的，"+jp.getSignature().getName()+"方法，返回值是："+result);
	}
	@AfterThrowing(pointcut="execution(* com.news.service..*.*(..))",throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.error("进入了异常抛出增强，调用了"+jp.getTarget()+"类的，"+jp.getSignature().getName()+"方法，抛出的异常是："+e);
	}
}
