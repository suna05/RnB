package com.web.insideframe.dao.movieReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.movieReply.MovieReplyDTO;
import com.web.insideframe.dto.reply.ReplyDTO;

public class MovieReplyDAO {
	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public void insert(MovieReplyDTO mrdto){
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("insert into movieno_comment values(moviecomment_seq.nextval,?,?,sysdate,?)");
			
			pstmt.setInt(1,mrdto.getComment_movieNo());
			pstmt.setString(2,mrdto.getCommentId());
			pstmt.setString(3,mrdto.getCommentContent());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieReplyDAO insert fail");
		}
	}
	public int commentTotalCount(int movieNo){
		int totalCount=0;
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select count(*) from movieno_comment where comment_movieno=?");
			
			pstmt.setInt(1,movieNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieReplyDAO totalCount fail !");
		}
		return totalCount;
	}
	public ArrayList<MovieReplyDTO> selectAll(int comment_movieno,int startRow,int endRow){
		MovieReplyDTO mrdto=null;
		ArrayList<MovieReplyDTO> mrList=new ArrayList<MovieReplyDTO>();
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select rownum NO,mcommentno,comment_movieno,mcommentid,mcommentdate,mcommentcontent from movieno_comment where comment_movieno=? order by mcommentno desc");
			
			pstmt.setInt(1,comment_movieno);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("NO")>=startRow && rs.getInt("NO")<=endRow){
					mrdto=new MovieReplyDTO(rs.getInt("mcommentno"),rs.getInt("comment_movieno")
							,rs.getString("mcommentid"),rs.getString("mcommentdate")
							,rs.getString("mcommentcontent"));
					mrList.add(mrdto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieReplyDAO selectAll fail !");
		}
		return mrList;
	}
}
