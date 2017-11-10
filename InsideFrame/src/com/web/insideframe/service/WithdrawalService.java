package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.memberdao.MemberDAO;
import com.web.insideframe.dto.memberdto.MemberDTO;

public class WithdrawalService {
	DaoFactory df=new DaoFactory();
	MemberDAO mdao=df.memberDao();
	
	public boolean withdrawal(MemberDTO mdto){
		boolean result=false;
		if(mdao.select(mdto.getEmail())!=null){
			mdao.delete(mdto.getEmail());
			result=true;
		}
		//���� career �� profile���� ���� �����Ǵ� �ڵ�����ؾ���
		return result;
	}
}
