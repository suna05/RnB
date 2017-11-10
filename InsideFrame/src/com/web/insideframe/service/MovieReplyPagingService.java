package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.movieReply.MovieReplyDAO;
import com.web.insideframe.dto.movieReply.MovieReplyDTO;
import com.web.insideframe.paging.Paging;

public class MovieReplyPagingService {
	DaoFactory df=new DaoFactory();
	Paging pg=new Paging();
	MovieReplyDAO mrdao=df.movieReplyDao();
	
	public Paging commentPaging(int movieNo){
		pg.setTotalCount(mrdao.commentTotalCount(movieNo));
		pg.makePaging();
		return pg;
	}
	public ArrayList<MovieReplyDTO> getCommentList(int movieNo,int commentCurPage){
		ArrayList<MovieReplyDTO> mrList=new ArrayList<MovieReplyDTO>();
		int startRow = (commentCurPage - 1) * pg.getPageSize() + 1;
		int endRow = startRow + (pg.getPageSize()-1);
		mrList=mrdao.selectAll(movieNo, startRow, endRow);
		return mrList;
	}
}
