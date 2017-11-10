package com.web.insideframe.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.service.LoginService;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pw=request.getParameter("pw");
		
		LoginService ls=new LoginService();
			request.getSession().setAttribute("member",ls.loginMember(email, pw));
	}
}
