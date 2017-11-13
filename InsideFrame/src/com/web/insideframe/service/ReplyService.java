package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.reply.ReplyDAO;
import com.web.insideframe.dto.reply.ReplyDTO;

public class ReplyService {
	DaoFactory df=new DaoFactory();
	ReplyDAO rdao=df.replyDao();
	CommentPagingService ps=new CommentPagingService();
	
	public ReplyDTO getReply(int idx,String email,String commentContent){
		ReplyDTO rdto=new ReplyDTO();
		
		rdto.setComment_board(idx);
		rdto.setCommentId(email);
		rdto.setCommentContent(commentContent);
		
		return rdto;
	}
	public void insertReply(ReplyDTO rdto){
		rdao.insert(rdto);
	}
}
