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
		logger.info("������ǰ����ǿ��������"+jp.getTarget()+"��ģ�"+jp.getSignature().getName()+"�����������ǣ�"+Arrays.toString(jp.getArgs()));
	}
	@AfterReturning(pointcut="execution(* com.news.service..*.*(..))",returning="result")
	public void afterReturning(JoinPoint jp,Object result){
		logger.info("�����˺�����ǿ��������"+jp.getTarget()+"��ģ�"+jp.getSignature().getName()+"����������ֵ�ǣ�"+result);
	}
	@AfterThrowing(pointcut="execution(* com.news.service..*.*(..))",throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.error("�������쳣�׳���ǿ��������"+jp.getTarget()+"��ģ�"+jp.getSignature().getName()+"�������׳����쳣�ǣ�"+e);
	}
}
