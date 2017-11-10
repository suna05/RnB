package com.web.insideframe.common;

import com.web.insideframe.dao.boarddao.BoardDAO;
import com.web.insideframe.dao.memberdao.CareerDAO;
import com.web.insideframe.dao.memberdao.MemberDAO;
import com.web.insideframe.dao.movieDetaildao.MovieDetailDAO;
import com.web.insideframe.dao.movieReply.MovieReplyDAO;
import com.web.insideframe.dao.moviedao.MovieDAO;
import com.web.insideframe.dao.reply.ReplyDAO;

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
	public ReplyDAO replyDao(){
		ReplyDAO rdao=new ReplyDAO();
		rdao.setConnection(connection());
		return rdao;
	}
	public MovieDAO movieDao(){
		MovieDAO mdao=new MovieDAO();
		mdao.setConnection(connection());
		return mdao;
	}
	public MovieDetailDAO movieDetailDao(){
		MovieDetailDAO mddao=new MovieDetailDAO();
		mddao.setConnection(connection());
		return mddao;
	}
	public MovieReplyDAO movieReplyDao(){
		MovieReplyDAO mrdao=new MovieReplyDAO();
		mrdao.setConnection(connection());
		return mrdao;
	}
}
