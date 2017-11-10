package com.web.insideframe.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.command.Command;
import com.web.insideframe.service.MovieReplyPagingService;
import com.web.insideframe.service.MovieReplyService;

public class MovieReplyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int movieNo=Integer.parseInt(request.getParameter("movieno"));
		String email=request.getParameter("commentid");
		String commentContent=request.getParameter("commentcontent");
		
		MovieReplyService mrs=new MovieReplyService();
		mrs.insertReply(mrs.getReply(movieNo, email, commentContent));
	}

}
