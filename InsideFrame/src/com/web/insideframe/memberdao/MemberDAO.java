package com.web.insideframe.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.memberdto.MemberDTO;
import com.web.insideframe.common.*;
public class MemberDAO {
	
	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	public void insert(MemberDTO mdto){
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("insert into member(email,pw,name,mtype) values(?,?,?,?)");
			
			pstmt.setString(1,mdto.getEmail());
			pstmt.setString(2,mdto.getPw());
			pstmt.setString(3,mdto.getName());
			pstmt.setString(4,mdto.getmType());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO insert fail");
		}
	}
	public MemberDTO select(String email){
		MemberDTO mdto=null;
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from member where email=?");
			
			pstmt.setString(1,email);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				mdto=new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setmType(rs.getString("mtype"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO select fail");
		}
		return mdto;
	}
	public void deleteAll(){
		try {
			Connection conn=connection.getConnetion();
			PreparedStatement pstmt=conn.prepareStatement("delete from member");
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO deleteAll fail");
		}
	}
	public void delete(String email){
		try {
			Connection conn=connection.getConnetion();
			PreparedStatement pstmt=conn.prepareStatement("delete from member where email=?");
			pstmt.setString(1,email);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO delete fail");
		}
	}
}
