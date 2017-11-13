package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.memberdto.MemberDTO;
import com.web.insideframe.service.JoinService;

public class JoinCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String mType=request.getParameter("type");
		String phone=request.getParameter("phone");
		String birth=request.getParameter("birth");
		MemberDTO mdto=new MemberDTO(email, pw, name, mType, birth, phone, sex);
		JoinService js=new JoinService();
		if(js.memberInsert(mdto)){
			request.setAttribute("member",mdto);
		}
	}

}
