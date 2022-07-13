package com.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class EmployAspect {

	@Before(value = "execution(* com.service.Employservice.*(..))")
	public void startMethod(JoinPoint joinPoint) {
		log.info("START" + joinPoint.getSignature().getName());
	}

	@After(value = "execution(* com.service.Employservice.*(..))")
	public void endmethod(JoinPoint joinpoint) {
		log.info("End" + joinpoint.getSignature().getName());

	}

}
