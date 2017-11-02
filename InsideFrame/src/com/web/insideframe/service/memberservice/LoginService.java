package com.web.insideframe.service.memberservice;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.memberdao.MemberDAO;
import com.web.insideframe.dto.memberdto.MemberDTO;

public class LoginService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public boolean loginCheck(String email,String pw){
		boolean result=false;
		
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
	public MemberDTO loginMember(String email,String pw){
		MemberDTO mdto=null;
		if(loginCheck(email,pw)){
			mdto=mdao.select(email);
			return mdto;
		}else return mdto;
	}
}
