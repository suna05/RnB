package com.web.rnb.replyimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.reply.ReplyDTO;

@Repository("ReplyDAO")
public class ReplyDAO {

  @Autowired
  private SqlSessionTemplate mybatis;
  
  public ReplyDAO() {
    System.out.println("reply DAO");
  }
  
  public void insertReply(ReplyDTO rdto) {
    mybatis.insert("ReplyDAO.insertReply", rdto);
  }
  
  public List<ReplyDTO> getListReply(int w_no) {
    return mybatis.selectList("ReplyDAO.getListReply",w_no);
  }
  
  
  public void updateReply(ReplyDTO rdto) {
    mybatis.update("ReplyDAO.updateReply", rdto);
  }
  
  public void deleteReply(ReplyDTO rdto) {
    mybatis.delete("ReplyDAO.deleteReply", rdto);
  }
}
