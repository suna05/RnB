package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.reply.ReplyDTO;
import com.web.insideframe.service.BoardDetailViewService;
import com.web.insideframe.service.CommentPagingService;
import com.web.insideframe.service.PagingService;
import com.web.insideframe.service.ReplyService;

public class BoardDetailViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idx=Integer.parseInt(request.getParameter("idx"));
		int commentPage=Integer.parseInt(request.getParameter("commentPage"));
		
		BoardDetailViewService bs=new BoardDetailViewService();
		request.setAttribute("board",bs.selectDetail(idx));
		//커맨트넘겨주는 부분까지
		
		CommentPagingService cps=new CommentPagingService();
		
		request.setAttribute("paging",cps.commentPaging(idx));
		request.setAttribute("commentList",cps.getCommentList(idx, commentPage));
	}

}
