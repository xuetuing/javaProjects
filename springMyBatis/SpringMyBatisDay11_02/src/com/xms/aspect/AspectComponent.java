package com.xms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//切面组件
@Component
@Aspect
public class AspectComponent {
	
	//@Before("within(com.xms.controller.*)")
	public void one(){
		System.out.println("前置通知");
	}
	//@AfterReturning("within(com.xms.controller.*)")
	public void two(){
		System.out.println("后置通知");
	}
	//@After("within(com.xms.controller.*)")
	public void three(){
		System.out.println("最终通知");
	}
	//@AfterThrowing(throwing="e",pointcut="within(com.xms.controller.*)")
	public void four(Exception e){
		System.out.println("异常通知");
		e.printStackTrace();
		StackTraceElement[] elements = e.getStackTrace();
		//记录异常信息
		System.out.println("---->"+elements[0].toString());
		
	}
	@Around("within(com.xms.controller.*)")
	public void five(ProceedingJoinPoint point) throws Throwable{
		System.out.println("环绕通知的前置部分");
		//执行目标组件的方法
		point.proceed();
		
		System.out.println("环绕通知的后置部分");
	}
	
	
}












