package com.web.rnb.common;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.photo.ProfilePhotoDTO;


@Service
@Aspect
public class AfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);
	
	@AfterReturning(pointcut="PointcutCommon.confirmPointCut()",returning="returnObj")
	public void confirmLogging(JoinPoint jp,Object returnObj) {
		logger.info("[confirmLogging] : "+jp.getSignature().getName()+"()");
		if(returnObj instanceof MemberDTO) {
			MemberDTO mdto=(MemberDTO)returnObj;
			logger.info("[confirmLogging] : "+mdto.toString());
		}else {
			logger.info("[confirmLogging] : confirmMember() FAIL ! ");
		}
	}
	
	@AfterReturning(pointcut="PointcutCommon.getPointCut()",returning="returnObj")
	public void getLogging(JoinPoint jp,Object returnObj) {
		logger.info("[getLogging] : "+jp.getSignature().getName()+"()");
		if(returnObj instanceof MemberDTO) {
			MemberDTO mdto=(MemberDTO)returnObj;
			logger.info("[getLogging] : "+mdto.toString());
		}else if(returnObj instanceof List){
			ArrayList list=(ArrayList)returnObj;
			logger.info("[getLogging] : "+list.size()+"개의 리스트 검색 성공");
		}else if(returnObj instanceof ProfilePhotoDTO){
			ProfilePhotoDTO pdto = (ProfilePhotoDTO)returnObj;
			logger.info("[getLogging] : "+pdto.getM_id()+"의 이미지 경로 : "+pdto.getPp_fullpath());
		}else {
			logger.info("[getLogging] : getMember() FAIL ! ");
			System.out.println("getMember() FAIL ! ");
		}
	}
}
