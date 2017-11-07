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
		//����Ǵ� ���� 3������ �ϳ��� ����Ǿ��ٸ� �������ִ� ������ �ٽ� ���ο� �������� ����⸦ �����Ѵ�.���� ��������
	}

}
