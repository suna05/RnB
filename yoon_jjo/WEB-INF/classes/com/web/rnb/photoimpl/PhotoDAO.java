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
  
  public void insertPhoto(PhotoDTO pdto) {
    mybatis.insert("PhotoDAO.insertPhoto", pdto);
  }
  
  public List<PhotoDTO> getListPhoto(PhotoPager photoPager) {
    return mybatis.selectList("PhotoDAO.getListPhoto", photoPager);
  }
  
  public PhotoDTO getPhoto(PhotoDTO pdto) {
    return (PhotoDTO)mybatis.selectOne("PhotoDAO.getDetailPhoto", pdto);
  }
  
  public void deletePhoto(PhotoDTO pdto) {
    mybatis.delete("PhotoDAO.deletePhoto", pdto);
  }
  
  public void updatePhoto(PhotoDTO pdto) {
    mybatis.update("PhotoDAO.updatePhoto", pdto);
  }
 public int getTotalCount(){
  return mybatis.selectOne("PhotoDAO.getTotalCount"); 
 }
 public void updateCount(PhotoDTO pdto) {
	 mybatis.update("PhotoDAO.updateCount",pdto);
 }
 
 public List<PhotoDTO> getListPopular(){
	 return mybatis.selectList("PhotoDAO.getListPopular");
 }
}
