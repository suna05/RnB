package com.web.rnb.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	@Pointcut("execution(* com.web.rnb..*.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.web.rnb..*Impl.insert*(..))")
	public void insertPointCut() {}
	
	@Pointcut("execution(* com.web.rnb..*Impl.get*(..))")
	public void getPointCut() {}
	
	@Pointcut("execution(* com.web.rnb..*Impl.confirm*(..))")
	public void confirmPointCut() {}
	
	@Pointcut("execution(* com.web.rnb..*Impl.ProfileFileUpload(..))")
	public void ProfileFileUpload() {}
	
	@Pointcut("execution(* com.web.rnb..*Impl.insertReply(..))")
	public void insertReplyPointCut() {}
}
