package com.web.insideframe.dao.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;

import com.web.insideframe.dto.boarddto.*;

public class BoardDAO {

	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public int totalCount(){
		int totalCount=0;
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select count(*) from board");
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BoardDAO totalCount fail !");
		}
		return totalCount;
	}
	public ArrayList<BoardDTO> boardList(int startRow,int endRow){
		BoardDTO bdto=null;
		ArrayList<BoardDTO> blist=new ArrayList<BoardDTO>();
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select rownum NO,idx,writer,btitle,bdate,btype,content,bcount from board order by idx desc");
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("NO")>=startRow && rs.getInt("NO")<= endRow){
					bdto=new BoardDTO(rs.getInt("idx"),rs.getString("writer"),
							rs.getString("btitle"),rs.getString("bdate"),
							rs.getString("btype"),rs.getString("content"),rs.getInt("bcount"));
					blist.add(bdto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}
	public BoardDTO select(int idx){
		BoardDTO bdto=null;
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select * from board where idx=?");
			
			pstmt.setInt(1,idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
					bdto=new BoardDTO(rs.getInt("idx"),rs.getString("writer"),
							rs.getString("btitle"),rs.getString("bdate"),
							rs.getString("btype"),rs.getString("content"),rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bdto;
	}
}
