package com.web.rnb.common;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.web.rnb.controller.MemberController;
import com.web.rnb.reply.ReplyDTO;
import com.web.rnb.reply.ReplyPhotoDTO;


@Service
@Aspect
public class BeforeAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);
	
	@Before("PointcutCommon.allPointCut()")
	public void beforeAllAdvice(JoinPoint jp) {
		logger.info("[beforeAdviceLog] : "+jp.getSignature().getName()+"()호출");
	}
	
	@Before("PointcutCommon.ProfileFileUpload()")
	public void beforeProfileAdvice(JoinPoint jp) {
		logger.info("[beforeProfileAdviceLog] : "+jp.getSignature().getName()+"()호출");
	}
	
	@Before("PointcutCommon.insertReplyPointCut()")
	public void beforeInsertReplyAdvice(JoinPoint jp) {
		logger.info("[beforeAdviceLog] : "+jp.getSignature().getName()+"()호출");
		Object[] obj=jp.getArgs();
		for(int i=0;i<obj.length;i++) {
			if(obj[i] instanceof ReplyDTO) {
				ReplyDTO rdto=(ReplyDTO)obj[i];
				String commentContent=rdto.getR_content();
				XssFilter xssFilter=XssFilter.getInstance("lucy-xss-superset.xml");
				String filterCommentContent=xssFilter.doFilter(commentContent);
				Pattern p=Pattern.compile("<!-- Not Allowed Tag Filtered -->");
				Matcher m=p.matcher(filterCommentContent);
				String xssResult="";
				if(m.find()){
					xssResult="비정상적인 댓글입니다.";
				}else{
					xssResult=commentContent;
				}
				if(!commentContent.equals(xssResult)) {
					logger.info("[beforeAdviceLog] : "+commentContent+"에서 "+xssResult+"로 댓글 내용 변경");
				}
				rdto.setR_content(xssResult);
			}else if(obj[i] instanceof ReplyPhotoDTO) {
				ReplyPhotoDTO rpdto=(ReplyPhotoDTO)obj[i];
				String commentContent=rpdto.getR_content();
				XssFilter xssFilter=XssFilter.getInstance("lucy-xss-superset.xml");
				String filterCommentContent=xssFilter.doFilter(commentContent);
				Pattern p=Pattern.compile("<!-- Not Allowed Tag Filtered -->");
				Matcher m=p.matcher(filterCommentContent);
				String xssResult="";
				if(m.find()){
					xssResult="비정상적인 댓글입니다.";
				}else{
					xssResult=commentContent;
				}
				if(!commentContent.equals(xssResult)) {
					logger.info("[beforeAdviceLog] : "+commentContent+"에서 "+xssResult+"로 댓글 내용 변경");
				}
				rpdto.setR_content(xssResult);
			}
		}
	}
}
