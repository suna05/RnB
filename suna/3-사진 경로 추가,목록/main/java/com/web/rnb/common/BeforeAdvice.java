package com.web.rnb.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class BeforeAdvice {
	String logMessage;
	@Before("PointcutCommon.allPointCut()")
	public void beforeAdvice(JoinPoint jp) {
		logMessage="[beforeAdviceLog] : "+jp.getSignature().getName()+"()»£√‚";
		System.out.println(logMessage);
	}
}
