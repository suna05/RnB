package com.web.rnb.common;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.web.rnb.member.MemberDTO;


@Service
@Aspect
public class AfterReturningAdvice {
	String logMessage;
	
	@AfterReturning(pointcut="PointcutCommon.confirmPointCut()",returning="returnObj")
	public void confirmLogging(JoinPoint jp,Object returnObj) {
		logMessage="[confirmLogging] : "+jp.getSignature().getName()+"()";
		System.out.print(logMessage+" ");
		if(returnObj instanceof MemberDTO) {
			MemberDTO mdto=(MemberDTO)returnObj;
			System.out.println(mdto.toString());
		}else {
			System.out.println("confirmMember() FAIL ! ");
		}
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointCut()",returning="returnObj")
	public void getLogging(JoinPoint jp,Object returnObj) {
		logMessage="[getLogging] : "+jp.getSignature().getName()+"()";
		System.out.print(logMessage+" ");
		if(returnObj instanceof MemberDTO) {
			MemberDTO mdto=(MemberDTO)returnObj;
			System.out.println(mdto.toString());
		}else if(returnObj instanceof List){
			ArrayList list=(ArrayList)returnObj;
			System.out.println(list.size()+"명의 리스트 검색 성공");
		}else {
			System.out.println("getMember() FAIL ! ");
		}
	}
}
