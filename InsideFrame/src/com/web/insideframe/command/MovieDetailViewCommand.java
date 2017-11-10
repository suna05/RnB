package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.service.MovieDetailViewService;
import com.web.insideframe.service.MovieReplyPagingService;

public class MovieDetailViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int movieNo=Integer.parseInt(request.getParameter("movieno"));
		int commentPage=Integer.parseInt(request.getParameter("commentPage"));
		
		MovieDetailViewService ms=new MovieDetailViewService();
		request.setAttribute("movie",ms.getMovieInfo(movieNo));
		request.setAttribute("peopleList",ms.getPeopleList(movieNo));
		
		MovieReplyPagingService mrps=new MovieReplyPagingService();
		
		request.setAttribute("paging",mrps.commentPaging(movieNo));
		request.setAttribute("commentList",mrps.getCommentList(movieNo, commentPage));
	}

}
