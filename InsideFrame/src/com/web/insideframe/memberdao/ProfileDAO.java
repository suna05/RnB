package com.web.insideframe.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.memberdto.MemberDTO;
import com.web.insideframe.memberdto.ProfileDTO;

public class ProfileDAO {
	DBConnection connection;
	PreparedStatement pstmt;
	ResultSet rs;
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public void insert(String email){
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("insert into profile(profileno,email) values(profileno_seq.nextval,?)");
			
			pstmt.setString(1,email);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ProfileDAO insert fail");
		}
	}
	public ProfileDTO select(String email){
		ProfileDTO pdto=null;
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from profile where email=?");
			
			pstmt.setString(1,email);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				pdto=new ProfileDTO();
				pdto.setEmail(rs.getString("email"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO select fail");
		}
		return pdto;
	}
	public void deleteAll(){
		try {
			Connection conn=connection.getConnetion();
			PreparedStatement pstmt=conn.prepareStatement("delete from profile");
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ProfileDAO deleteAll fail");
		}
	}
}
