package com.web.rnb.common;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.rnb.controller.MemberController;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.todolist.ToDoListDTO;
import com.web.rnb.todolist.ToDoListService;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Autowired
	ToDoListService toDoListService;
	//컨트롤러의 기능을 완료하고 view를 리턴하기 전에 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	//컨트롤러를 가기전에 호출되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("member");
		if(obj==null) {
			response.sendRedirect("home.do");
			return false;//false이면 컨트롤러를 수행하지 않는다.
		}else if(obj instanceof MemberDTO){
			MemberDTO mdto=(MemberDTO)obj;
			ToDoListDTO tdto=new ToDoListDTO();
			tdto.setM_id(mdto.getM_id());
			List<ToDoListDTO> list=toDoListService.getToDoList(tdto);
			double totalNum=list.size();
			double obtainNum=0;
			Iterator<ToDoListDTO> it = list.iterator();
			while(it.hasNext()) {
				if(Integer.parseInt(it.next().getObtain())==1) {
					obtainNum++;
				}
			}
			int rate = (int) ((obtainNum/totalNum)*100);
			request.setAttribute("rate", rate);
		}
		return super.preHandle(request, response, handler);
	}
	

}
