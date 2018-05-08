package com.web.rnb.photo;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.web.rnb.photoimpl.PhotoPager;


public interface PhotoService {
  
  List<PhotoDTO> getListPhoto(PhotoPager photoPager);
  
  void insertPhoto(PhotoDTO pdto);

  PhotoDTO getPhoto(PhotoDTO pdto);
  
  void deletePhoto(PhotoDTO pdto);
  
  void updatePhoto(PhotoDTO pdto);
  
  int getTotalCount();
  
  boolean isUpdateCount(PhotoDTO pdto,HttpSession session,Cookie[] cookie,String m_id) throws UnsupportedEncodingException;
  
  void updateCount(PhotoDTO pdto);
  
  public List<PhotoDTO> getListPopular();
}