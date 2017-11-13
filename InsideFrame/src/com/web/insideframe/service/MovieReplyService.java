package com.web.insideframe.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.movieReply.MovieReplyDAO;
import com.web.insideframe.dto.movieReply.MovieReplyDTO;

public class MovieReplyService {
	DaoFactory df=new DaoFactory();
	MovieReplyDAO mrdao=df.movieReplyDao();
	
	public MovieReplyDTO getReply(int movieNo,String email,String commentContent){
		MovieReplyDTO mrdto=new MovieReplyDTO();
		
		mrdto.setComment_movieNo(movieNo);
		mrdto.setCommentId(email);
		mrdto.setCommentContent(commentContent);
		
		return mrdto;
	}
	public void insertReply(MovieReplyDTO mrdto){
		mrdao.insert(mrdto);
	}
	/*public boolean isXssAttack(String commentContent){
		boolean result=false;
		Pattern p=Pattern.compile("<!-- Not Allowed Tag Filtered -->");
		Matcher m=p.matcher(commentContent);
		if(m.matches()){
			result=true;
		}
		return result;
	}*/
}
