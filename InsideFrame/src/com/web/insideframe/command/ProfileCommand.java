package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.memberdto.MemberDTO;
import com.web.insideframe.service.memberservice.ProfileService;

public class ProfileCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProfileService ps=new ProfileService();
		request.setAttribute("member",ps.getMemberDto((MemberDTO)request.getSession().getAttribute("member")));
	}

}
