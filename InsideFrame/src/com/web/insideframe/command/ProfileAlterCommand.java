package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.memberdto.MemberDTO;
import com.web.insideframe.service.memberservice.ProfileAlterService;

public class ProfileAlterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDTO mdto=(MemberDTO)request.getSession().getAttribute("member");
		String email=mdto.getEmail();
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		System.out.println("email:"+email+" pw:"+pw+" name:"+name+" phone:"+phone);
		ProfileAlterService ps=new ProfileAlterService();
		ps.profileAlter(email,pw, name, phone);
		//변경되는 정보 3가지중 하나라도 변경되었다면 기존에있는 세션을 다시 새로운 세션으로 덮어쓰기를 진행한다.추후 수정진행
	}

}
