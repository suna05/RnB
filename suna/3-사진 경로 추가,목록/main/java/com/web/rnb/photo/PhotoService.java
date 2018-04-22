package com.web.rnb.photo;

import java.util.List;
import java.util.Map;


public interface PhotoService {
  
  void insertPhoto(PhotoDTO pdto);
  List<PhotoDTO> getListPhoto();
  /*void updatePhoto(PhotoDTO pdto);
  void deletePhoto(PhotoDTO pdto);*/
  void insertBoardPhoto(BoardPhotoDTO pdto);

  BoardPhotoDTO getBoardPhoto(PhotoDTO pdto);
  //void insertBoardPhoto(BoardPhotoDTO pdto);

  //BoardPhotoDTO getBoardPhoto(PhotoDTO pdto);
  
}
