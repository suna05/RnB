package com.web.rnb.photoimpl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.photo.PhotoDTO;


@Repository("PhotoDAO")
public class PhotoDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public PhotoDAO() {
    System.out.println("photo DAO");
  }
  
  public void insertPhoto(PhotoDTO pdto) {
    mybatis.insert("PhotoDAO.insertPhoto", pdto);
  }
  
  public List<PhotoDTO> getListPhoto() {
    return mybatis.selectList("PhotoDAO.getListPhoto");
  }
}
