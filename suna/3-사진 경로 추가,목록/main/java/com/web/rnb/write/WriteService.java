package com.web.rnb.write;

import java.util.List;

import com.web.rnb.writeimpl.WriteDAO;


public interface WriteService {
  
  void insertWrite(WriteDTO wdto);
  List<WriteDTO> getListWrite();

  WriteDTO getWrite();
  
  //상세 게시물
  WriteDTO getDetail(WriteDTO wdto);
  List<WriteDTO> getDetailWrite(int w_no);
  WriteDTO getWrite(WriteDTO wdto);
  
}
