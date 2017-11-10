package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.memberdao.MemberDAO;
import com.web.insideframe.dto.memberdto.MemberDTO;

public class JoinService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public boolean memberCheck(String email){
		boolean result=false;
		if(mdao.select(email)==null){
			result=true;
			return result;
		}
		return result;
	}
	public boolean memberInsert(MemberDTO mdto){
		boolean result=false;
		if(memberCheck(mdto.getEmail())==true){
			mdao.insert(mdto);
			result=true;
			return result;
		}
		return result;
	}
}
