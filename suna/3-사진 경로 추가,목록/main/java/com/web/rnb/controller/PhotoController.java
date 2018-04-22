package com.web.rnb.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.photo.BoardPhotoService;
import com.web.rnb.photo.PhotoDTO;
import com.web.rnb.photo.PhotoService;
import com.web.rnb.photoimpl.BoardFileUpload;

@Controller
public class PhotoController {

  @Autowired 
  ServletContext ctx;
  @Autowired
  BoardPhotoService bps;
  @Autowired
  BoardFileUpload bfu;
  @Autowired
  PhotoService photoService;
/*  @Autowired
  BoardPhotoService boardPhotoService;*/
  
  
  @RequestMapping(value="/insertPhoto.do",method=RequestMethod.POST)
  public ModelAndView insertPhoto(HttpServletRequest request, @RequestParam("boardPhoto")MultipartFile multipartFile,
     PhotoDTO pdto, ModelAndView mav) {
    //int result=0;
    
    System.out.println(pdto.getP_title());
    
   
    System.out.println("files: "+multipartFile.getOriginalFilename());
    if(pdto==null) System.out.println("pdto null값임");
    if(pdto!=null) System.out.println("pdto null값 아님");
    
    //BoardPhotoService.insertBoardPhoto(bpdto);

    if(multipartFile.getOriginalFilename()!=null) {
      if(bfu.uploadFile(request, multipartFile, pdto)) {
        System.out.println("multipartFile");
      } else {
        //result=1;
        System.out.println("Error");
      }
    
      photoService.insertPhoto(pdto);
    
    }
    mav.setViewName("redirect:getListPhoto.do");
      return mav;
  }
  
  
  
 @RequestMapping(value="/getListPhoto.do")
  public ModelAndView getListPhoto(ModelAndView mav)  {
      ArrayList<PhotoDTO> list=(ArrayList<PhotoDTO>) photoService.getListPhoto();
      
      Iterator<PhotoDTO> it=list.iterator();
      while(it.hasNext()){
        System.out.println(it.next().toString());
      }
      
      
      mav.addObject("getListPhoto",list);
      //mav.addObject("getListPhoto",photoService.photolist(pageNo, pageSize));
      mav.setViewName("photolist");
      return mav;
      
      
  }
  
 }
 
