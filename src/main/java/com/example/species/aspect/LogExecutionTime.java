package com.example.species.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTime {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("within(com.example.species.service..*)")
	public Object print(ProceedingJoinPoint joinPoint) {
		Long startTime = System.currentTimeMillis();
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			logger.info("Temps d'execution de la methode {} dans {} : {}", joinPoint.getSignature().getName(),
					joinPoint.getTarget().getClass().getSimpleName(), System.currentTimeMillis() - startTime + " ms");
		}
		return result;
	}

}
