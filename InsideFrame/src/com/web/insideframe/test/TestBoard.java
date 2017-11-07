package com.web.insideframe.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.boarddao.BoardDAO;
import com.web.insideframe.dao.memberdao.MemberDAO;

public class TestBoard {
	@Test
	public void totalCount(){
		DaoFactory df=new DaoFactory();
		BoardDAO bdao=df.boardDao();
		
		assertThat(bdao.totalCount(), is(1));
		System.out.println(bdao.totalCount());
	}
}
