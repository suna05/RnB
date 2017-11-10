package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.service.ReplyService;

public class ReplyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idx=Integer.parseInt(request.getParameter("comment_board"));
		String email=request.getParameter("commentid");
		String commentContent=request.getParameter("commentcontent");
		
		ReplyService rs=new ReplyService();
		rs.insertReply(rs.getReply(idx, email, commentContent));
	}

}
