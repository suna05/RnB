package com.web.rnb.photoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.photo.PhotoDTO;
import com.web.rnb.photo.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{
  @Autowired
  private PhotoDAO pdao;
  
  @Autowired
  private BoardPhotoDAO bpdao;
  
  public PhotoServiceImpl() {
    System.out.println("PhotoServiceImpl()");
  }

  @Override
  public void insertPhoto(PhotoDTO pdto) {
    // TODO Auto-generated method stub
    System.out.println("PhotoServiceImpl().insertPhoto");
    pdao.insertPhoto(pdto);
  }
  
  @Override
  public List<PhotoDTO> getListPhoto() {
    List<PhotoDTO>list =pdao.getListPhoto();
    Iterator<PhotoDTO> it=((ArrayList)list).iterator();
    while(it.hasNext()) System.out.println(it.next().getP_title());
      return list;
  }
  
  @Override
  public void insertBoardPhoto(BoardPhotoDTO bpdto) {
    bpdao.insertBoardPhoto(bpdto);
    
  }

  @Override
  public BoardPhotoDTO getBoardPhoto(PhotoDTO pdto) {
    return bpdao.getboardPhoto(pdto);
  }
  

  
  
  
}
