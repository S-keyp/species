package com.example.species.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogIfException {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterThrowing(value="execution(* com.example.species..*.*create*(..))",throwing="exception")
	public void print(JoinPoint joinPoint, Exception exception) {
		logger.info("Exception dans la methode {} de {} jetee : {}", 
				joinPoint.getSignature().getName(),
				joinPoint.getTarget().getClass().getSimpleName(),
				exception.getMessage());
	}
	
}
