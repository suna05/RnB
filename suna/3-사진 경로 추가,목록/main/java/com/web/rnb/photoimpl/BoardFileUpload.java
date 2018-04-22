package com.web.rnb.photoimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.photo.BoardPhotoService;
import com.web.rnb.photo.PhotoDTO;

@Service
public class BoardFileUpload {
  @Autowired
  com.web.rnb.photo.PhotoService PhotoService;
  public boolean uploadFile(HttpServletRequest request,MultipartFile multipartFile, PhotoDTO pdto) {
      
      boolean result=false;
      //코드내에서 컨텍스트의 절대경로를 가져와 저장할 폴더의 경로를 붙여준다. 즉, 파일이 저장될 위치이다.
      //String savePath =request.getSession().getServletContext().getRealPath("/resources/profilePhoto/");
      String savePath ="C:\\workspace\\jjo_suna\\src\\main\\webapp\\resources\\boardPhoto";
      //파일의 원래이름 filename.jpg
      String originalFileName=multipartFile.getOriginalFilename();
      System.out.println(originalFileName);
      //filename (확장자를 제외한)
      String onlyFileName=originalFileName.substring(0, originalFileName.indexOf("."));
      System.out.println(onlyFileName);
      //.jpg 확장자만
      String extension=originalFileName.substring(originalFileName.indexOf("."));
      System.out.println(extension);
      //이름 중복방지를 위한 RENAME 날짜를 파일명뒤에 붙여준다.
      String rename=onlyFileName+"_"+System.currentTimeMillis()+extension;
      System.out.println(rename);
      //경로와 파일명을 포함한 fullPath
      String fullPath=savePath+"\\"+rename;
      System.out.println(fullPath);
      
      PhotoDTO pdto1=new PhotoDTO();
      pdto1.setBp_fullpath(fullPath);
      System.out.println(pdto1.toString());
      
      if(!multipartFile.isEmpty()) {
          try {
              byte[] bytes=multipartFile.getBytes();
              BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
              bos.write(bytes);
              bos.close();
              result=true;
          }catch (Exception e) {
              // TODO: handle exception
              e.getMessage();
              return result;
          }
      }else {
          //파일이 없을때
      }
      PhotoService.insertPhoto(pdto1);
      return result;
  }
}
