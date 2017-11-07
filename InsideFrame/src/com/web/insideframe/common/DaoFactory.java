package com.web.insideframe.common;

import com.web.insideframe.dao.boarddao.BoardDAO;
import com.web.insideframe.dao.memberdao.CareerDAO;
import com.web.insideframe.dao.memberdao.MemberDAO;

public class DaoFactory {
	public DBConnection connection(){
		DBConnection connection=new OracleConnection();
		
		return connection;
	}
	public MemberDAO memberDao(){
		MemberDAO mdao=new MemberDAO();
		mdao.setConnection(connection());
		return mdao;
	}
	public CareerDAO careerDao(){
		CareerDAO cdao=new CareerDAO();
		cdao.setConnection(connection());
		return cdao;
	}
	public BoardDAO boardDao(){
		BoardDAO bdao=new BoardDAO();
		bdao.setConnection(connection());
		return bdao;
	}
}
