package com.web.insideframe.memberservice;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.memberdao.MemberDAO;
import com.web.insideframe.memberdto.MemberDTO;

public class WithdrawalService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public boolean withdrawal(MemberDTO mdto){
		boolean result=false;
		if(mdao.select(mdto.getEmail())!=null){
			mdao.delete(mdto.getEmail());
			result=true;
		}
		//추후 career 및 profile까지 같이 삭제되는 코드삽입해야함
		return result;
	}
}
