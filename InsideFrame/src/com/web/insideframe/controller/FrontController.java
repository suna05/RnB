package com.web.insideframe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.command.*;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		commandAction(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		commandAction(request,response);
	}
	private void commandAction(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
		String viewPage=null; //요청에 대한 응답을 받을 페이지
		Command command=null; //로직수행을 위한 command생성자
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String comName=uri.substring(conPath.length());
		if(comName.equals("/JSP/join.do")){
			command=new JoinCommand();
			command.execute(request, response);
			viewPage="joinOk.jsp";
		}else if(comName.equals("/JSP/joinPage.do")){
			viewPage="join.jsp";
		}else if(comName.equals("/JSP/loginPage.do")){
			viewPage="login.jsp";
		}else if(comName.equals("/JSP/login.do")){
			command=new LoginCommand();
			command.execute(request, response);
			viewPage="index.jsp";
		}else if(comName.equals("/JSP/logout.do")){
			command=new LogoutCommand();
			command.execute(request, response);
			viewPage="index.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}

}
