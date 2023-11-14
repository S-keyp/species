package com.example.species.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAfterGetMethod {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* com.example.species..*.*get*(..))")
	public void print(JoinPoint joinPoint) {
		logger.info("Getter execute par la methode {} de la classe {}", 
				joinPoint.getSignature().getName(),
				joinPoint.getTarget().getClass().getSimpleName());
	}
	
}