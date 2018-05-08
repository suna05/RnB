package com.web.rnb.photoimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.photo.PhotoDTO;

@Repository("BoardPhotoDAO")
public class BoardPhotoDAO {

  @Autowired
  private SqlSessionTemplate mybatis;
  
  public void insertBoardPhoto(BoardPhotoDTO bpdto) {
    mybatis.insert("boardPhotoDAO.insertBoardPhoto", bpdto);
    
  }
  

  public BoardPhotoDTO getboardPhoto(PhotoDTO pdto) {
   
    return (BoardPhotoDTO)mybatis.selectOne("BoardPhotoDAO.getBoardPhoto", pdto);
  }
  
  
  
  
  

}
