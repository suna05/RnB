package com.web.insideframe.service;

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
}
