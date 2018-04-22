package com.web.rnb.writeimpl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.write.WriteDTO;


@Repository("WriteDAO")
public class WriteDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public WriteDAO() {
    System.out.println("write DAO");
  }
  
  public void insertWrite(WriteDTO wdto) {
    mybatis.insert("WriteDAO.insertWrite", wdto);
  }
  
  public WriteDTO getWrite(WriteDTO wdto) {
    return (WriteDTO)mybatis.selectOne("WriteDAO.getWrite", wdto);
  }
  
  public List<WriteDTO> getListWrite() {
    return mybatis.selectList("WriteDAO.getListWrite");
  }
  
  
/*  public WriteDTO getDetal() {
    
  }*/
}
