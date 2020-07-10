package com.ab.restfulws.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfiguartion {

	@Pointcut("execution(* com.ab.restfulws.repository.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.ab.restfulws.service.*.*(..))")
	public void businessLayerExecution() {
	}

}
