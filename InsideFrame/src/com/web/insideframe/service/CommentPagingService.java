package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.boarddao.BoardDAO;
import com.web.insideframe.dao.reply.ReplyDAO;
import com.web.insideframe.dto.reply.ReplyDTO;
import com.web.insideframe.paging.Paging;

public class CommentPagingService {
	DaoFactory df=new DaoFactory();
	Paging pg=new Paging();
	ReplyDAO rdao=df.replyDao();
	
	public Paging commentPaging(int idx){
		pg.setTotalCount(rdao.commentTotalCount(idx));
		pg.makePaging();
		return pg;
	}
	
	public ArrayList<ReplyDTO> getCommentList(int idx,int commentCurPage){
		ArrayList<ReplyDTO> rList=new ArrayList<ReplyDTO>();
		int startRow = (commentCurPage - 1) * pg.getPageSize() + 1;
		int endRow = startRow + (pg.getPageSize()-1);
		rList=rdao.selectAll(idx, startRow, endRow);
		return rList;
	}
}
