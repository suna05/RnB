package com.web.rnb.replyimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.reply.ReplyPhotoDTO;

@Repository("ReplyPhotoDAO")
public class ReplyPhotoDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public ReplyPhotoDAO() {
		System.out.println("replyPhoto DAO");
	}

	public void insertReply(ReplyPhotoDTO rdto) {
		System.out.println("mybatis insertreply222");
		mybatis.insert("ReplyPhotoDAO.insertReply", rdto);
	}

	public List<ReplyPhotoDTO> getListReply(int p_no) {
		return mybatis.selectList("ReplyPhotoDAO.getListReply",p_no);
	}

	public void updatePhotoReply(ReplyPhotoDTO rdto) {
	  System.out.println("업데이트 포토 DAO");
		mybatis.update("ReplyPhotoDAO.updatePhotoReply", rdto);
	}
	
	public void deletePhotoReply(ReplyPhotoDTO rdto) {
	  mybatis.delete("ReplyPhotoDAO.deleteReply", rdto);
	}
	
	
}