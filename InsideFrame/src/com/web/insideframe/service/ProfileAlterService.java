package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.memberdao.MemberDAO;

public class ProfileAlterService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public void profileAlter(String email,String pw,String name,String phone){
		mdao.update(email,pw, name, phone);
	}
}
