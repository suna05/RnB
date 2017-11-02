package com.web.insideframe.test;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.web.insideframe.common.*;
import com.web.insideframe.dao.memberdao.MemberDAO;
import com.web.insideframe.dto.memberdto.*;
import com.web.insideframe.service.memberservice.JoinService;
import com.web.insideframe.service.memberservice.LoginService;
import com.web.insideframe.service.memberservice.WithdrawalService;

public class TestMain {
	@Test
	public void joinCheckAndInsert(){
		DaoFactory df=new DaoFactory();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","윤여성","감독","abc","92.12.23",177,77,"010-6611-8156","남성");
		MemberDTO mdto2=new MemberDTO("1223yys@naver.com","1234","윤여성","감독","abc","92.12.23",177,77,"010-6611-8156","남성");
		MemberDAO mdao=df.memberDao();
		
		JoinService js=new JoinService();
		assertThat(js.memberInsert(mdto2),is(true));
	}
	@Test
	public void loginCheck(){
		DaoFactory df=new DaoFactory();
		MemberDAO mdao=df.memberDao();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","윤여성","감독","abc","92.12.23",177,77,"010-6611-8156","남성");
		
		LoginService ls=new LoginService();
		assertThat(ls.loginCheck(mdto.getEmail(),mdto.getPw()),is(true));
		assertThat(ls.loginCheck("ysung1223@nate.com","1234"),is(false));
	}
	@Test
	public void withdrawalCheck(){
		DaoFactory df=new DaoFactory();
		MemberDAO mdao=df.memberDao();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","윤여성","감독","abc","92.12.23",177,77,"010-6611-8156","남성");
		
		WithdrawalService ws=new WithdrawalService();
		
		assertThat(ws.withdrawal(mdto), is(true));
	}
}
