package com.web.insideframe.memberservice;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.memberdao.MemberDAO;
import com.web.insideframe.memberdto.MemberDTO;

public class LoginService {
	public boolean loginCheck(String email,String pw){
		boolean result=false;
		DaoFactory df=new DaoFactory();
		MemberDAO mdao=df.memberDao();
		MemberDTO mdto=mdao.select(email);
		if(mdto==null){
			return result;
		}
		else if(mdto.getEmail().equals(email)){
			if(mdto.getPw().equals(pw)){
				result=true;
			}
			else return result;
		}
		return result;
	}
}
