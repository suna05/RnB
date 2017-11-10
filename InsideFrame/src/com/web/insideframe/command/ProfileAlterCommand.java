package com.web.insideframe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.memberdto.MemberDTO;
import com.web.insideframe.service.ProfileAlterService;

public class ProfileAlterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDTO mdto=(MemberDTO)request.getSession().getAttribute("member");
		String email=mdto.getEmail();
		String pw=request.getParameter("pw");
		String phone=request.getParameter("phone");
		String mimage=request.getParameter("mimage");
		System.out.println("email:"+email+" pw:"+pw+"mimage="+mimage+" phone:"+phone);
		ProfileAlterService ps=new ProfileAlterService();
		ps.profileAlter(email,pw, phone,mimage);
		//����Ǵ� ���� 3������ �ϳ��� ����Ǿ��ٸ� �������ִ� ������ �ٽ� ���ο� �������� ����⸦ �����Ѵ�.���� ��������
	}

}
