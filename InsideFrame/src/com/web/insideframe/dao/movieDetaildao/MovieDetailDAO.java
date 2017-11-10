package com.web.insideframe.dao.movieDetaildao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.movieDetaildto.MovieDetailDTO;
import com.web.insideframe.dto.moviedto.MovieDTO;

public class MovieDetailDAO {
DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public ArrayList<MovieDetailDTO> getMovieDetailList(int movieNo){
		MovieDetailDTO mddto=null;
		ArrayList<MovieDetailDTO> mdList=new ArrayList<MovieDetailDTO>();
		
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select mv.youtubelink,mv.movieimage,mv.movieinfo,mv.mdate,mb.mimage,mb.mtype,mb.name,c.roll"
					+ " from member mb,movie mv, career c where mb.email=c.email and mv.movieno=c.movieno and mv.movieno=?");
			pstmt.setInt(1,movieNo);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				mddto=new MovieDetailDTO();
				mddto.setYoutubeLink(rs.getString("youtubelink"));
				mddto.setMovieImage(rs.getString("movieimage"));
				mddto.setMovieInfo(rs.getString("movieinfo"));
				mddto.setMdate(rs.getString("mdate"));
				mddto.setMimage(rs.getString("mimage"));
				mddto.setmType(rs.getString("mtype"));
				mddto.setName(rs.getString("name"));
				mddto.setRoll(rs.getString("roll"));
				
				mdList.add(mddto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectAll fail");
		}
		return mdList;
	}
	
	public MovieDTO getMovieInfo(int movieNo){
		MovieDTO mdto=null;
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select youtubelink,movieimage,movieinfo,mdate from movie where movieno=?");
			pstmt.setInt(1,movieNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				mdto=new MovieDTO();
				mdto.setYoutubeLink(rs.getString("youtubelink"));
				mdto.setMovieImage(rs.getString("movieimage"));
				mdto.setMovieInfo(rs.getString("movieinfo"));
				mdto.setMdate(rs.getString("mdate"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectAll fail");
		}
		return mdto;
	}
}
