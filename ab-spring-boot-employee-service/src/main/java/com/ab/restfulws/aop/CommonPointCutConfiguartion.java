package com.ab.restfulws.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfiguartion {

	@Pointcut("execution(* com.ab.restfulws.controller.*.*(..))")
	public void controllerLayerExecution() {
	}



	@Pointcut("execution(* com.ab.restfulws.controller.*.*(..))")
	public void trackTime() {
	}

}
