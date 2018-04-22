package com.web.rnb.photoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.photo.BoardPhotoService;
import com.web.rnb.photo.PhotoDTO;

@Service
public class BoardServiceImpl implements BoardPhotoService {
  
  @Autowired
  private BoardPhotoDAO bpdao;
  
  @Transactional
  @Override
  public void insertBoardPhoto(BoardPhotoDTO bpdto) {
    bpdao.insertBoardPhoto(bpdto);
    
  }

  @Override
  public BoardPhotoDTO getBoardPhoto(PhotoDTO pdto) {
    return bpdao.getboardPhoto(pdto);
  }
  
}
