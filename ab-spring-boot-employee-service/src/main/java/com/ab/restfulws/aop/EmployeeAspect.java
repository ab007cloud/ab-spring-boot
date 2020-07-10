package com.ab.restfulws.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EmployeeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("com.ab.restfulws.aop.CommonPointCutConfiguartion.controllerLayerExecution()")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Before the execution of  {} ", joinPoint);

	}

	@AfterReturning(value = "com.ab.restfulws.aop.CommonPointCutConfiguartion.controllerLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@After(value = "com.ab.restfulws.aop.CommonPointCutConfiguartion.controllerLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}

}
