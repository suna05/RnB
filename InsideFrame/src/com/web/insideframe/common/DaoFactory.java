package com.web.insideframe.common;

import com.web.insideframe.memberdao.CareerDAO;
import com.web.insideframe.memberdao.MemberDAO;
import com.web.insideframe.memberdao.ProfileDAO;

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
	public ProfileDAO profileDao(){
		ProfileDAO	pdao=new ProfileDAO();
		pdao.setConnection(connection());
		return pdao;
	}
}
