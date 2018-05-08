package com.web.rnb.reply;

import java.util.List;

public interface ReplyService {

  void insertReply(ReplyDTO rdto);
  
  List<ReplyDTO> getListReply(int w_no);
  
  void updateReply(ReplyDTO rdto);

  void deleteReply(ReplyDTO rdto);
}
