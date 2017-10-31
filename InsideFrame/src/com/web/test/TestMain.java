package com.web.test;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.web.insideframe.memberdao.MemberDAO;
import com.web.insideframe.memberdao.ProfileDAO;
import com.web.insideframe.memberdto.*;
import com.web.insideframe.memberservice.JoinService;
import com.web.insideframe.memberservice.LoginService;
import com.web.insideframe.memberservice.WithdrawalService;
import com.web.insideframe.common.*;

public class TestMain {
	@Test
	public void profileInsertAndSelect(){
		DaoFactory df=new DaoFactory();
		String email="ysung1223@nate.com";
		ProfileDAO pdao=df.profileDao();
		
		pdao.deleteAll();
		pdao.insert(email);
		ProfileDTO pdto=pdao.select(email);
		assertThat(pdto.getEmail(),is(email));
	}
	@Test
	public void joinCheckAndInsert(){
		DaoFactory df=new DaoFactory();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","À±¿©¼º","°¨µ¶");
		MemberDTO mdto2=new MemberDTO("1223yys@naver.com","1234","À±¿©¼º","°¨µ¶");
		MemberDAO mdao=df.memberDao();
		
		JoinService js=new JoinService();
		assertThat(js.memberInsert(mdto),is(false));
		assertThat(js.memberInsert(mdto2),is(true));
	}
	@Test
	public void loginCheck(){
		DaoFactory df=new DaoFactory();
		MemberDAO mdao=df.memberDao();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","À±¿©¼º","°¨µ¶");
		
		LoginService ls=new LoginService();
		assertThat(ls.loginCheck(mdto.getEmail(),mdto.getPw()),is(true));
		assertThat(ls.loginCheck("ysung1223@nate.com","1234"),is(false));
	}
	@Test
	public void withdrawalCheck(){
		DaoFactory df=new DaoFactory();
		MemberDAO mdao=df.memberDao();
		MemberDTO mdto=new MemberDTO("1223@nate.com","1234","À±¿©¼º","°¨µ¶");
		
		WithdrawalService ws=new WithdrawalService();
		
		assertThat(ws.withdrawal(mdto), is(true));
	}
}
