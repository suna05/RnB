package com.web.rnb.writeimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.write.WriteDTO;
import com.web.rnb.write.WriteService;

@Service
public class WriteServiceImpl implements WriteService{
  
  @Autowired
  private WriteDAO wdao;
  
  public WriteServiceImpl() {
    System.out.println("WriteServiceImpl()");
  }

  @Override
  public void insertWrite(WriteDTO wdto) {
    wdao.insertWrite(wdto);
  }
  
  @Override
  public WriteDTO getWrite(WriteDTO wdto) {
    return wdao.getWrite(wdto);
  }
  
  
  @Override
  public List<WriteDTO> getListWrite() {
    List<WriteDTO>list =wdao.getListWrite();
    Iterator<WriteDTO> it=((ArrayList)list).iterator();
    while(it.hasNext()) System.out.println(it.next().getW_title());
      return list;
  }
  
  @Override
  public List<WriteDTO> getDetailWrite(int w_no) {
    List<WriteDTO>list =wdao.getListWrite();
    
    Iterator<WriteDTO> it=((ArrayList)list).iterator();
    while(it.hasNext()) 
      System.out.println(it.next().getW_no());
      return list;
  }
  
  @Override
  public WriteDTO getDetail(WriteDTO wdto){
    return wdto;
  }

  @Override
  public WriteDTO getWrite() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
