package com.web.rnb.replyimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.web.rnb.reply.ReplyDTO;
import com.web.rnb.reply.ReplyService;
import com.web.rnb.write.WriteDTO;

@Service
public class ReplyServiceImpl implements  ReplyService {
  
  @Autowired
  private ReplyDAO rdao;
  
  public ReplyServiceImpl() {
    System.out.println("ReplyServiceImpl()");
  }
  
  @Override
  public void insertReply(ReplyDTO rdto) {
	  rdao.insertReply(rdto);
  }
  
  @Override
  public List<ReplyDTO> getListReply(int w_no) {
    List<ReplyDTO> list=rdao.getListReply(w_no);
    return list;
    
  }

  @Override
  public void updateReply(ReplyDTO rdto) {
    rdao.updateReply(rdto);
  }
  
  @Override
  public void deleteReply(ReplyDTO rdto) {
    rdao.deleteReply(rdto);
  }
  
  
}
