package com.web.rnb.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.message.stream.StreamAttachment;
import com.web.rnb.write.WriteDTO;
import com.web.rnb.write.WriteService;
import com.web.rnb.writeimpl.WriteDAO;


@Controller
public class WriteController {
  
  @Autowired 
  WriteService writeService;
 
  @RequestMapping(value="/insertWrite.do", method=RequestMethod.POST)
  public ModelAndView insertWrite(WriteDTO wdto, ModelAndView mav) {
    System.out.println(wdto.getW_content());
    if(wdto==null) {
      System.out.println("null!!!");
    }
      writeService.insertWrite(wdto);
      System.out.println("insertWrite");
      mav.setViewName("redirect:getListWrite.do");
      return mav;
  }
  
  
  @RequestMapping(value="/getListWrite.do")
  public ModelAndView getListWrite(ModelAndView mav)  {
   

    if(mav==null) {
      System.out.println("mav null");
    }
     
    ArrayList<WriteDTO> list=(ArrayList<WriteDTO>) writeService.getListWrite();
    System.out.println("getListwrite");
       
       Iterator<WriteDTO> it=list.iterator();
       while(it.hasNext()){
         System.out.println(it.next().toString());
       }

       mav.addObject("getListWrite",list);
       
       mav.setViewName("getListWrite");

       return mav;
      
  }
  
  //@ResponseBody
  @RequestMapping(value="/getDetailWrite.do")
  public ModelAndView getWrite(ModelAndView mav)   {

    
    if(mav==null) {
      System.out.println("mav null");
    }
     
    ArrayList<WriteDTO> list=(ArrayList<WriteDTO>) writeService.getListWrite();
    System.out.println("getListwrite");
       
       Iterator<WriteDTO> it=list.iterator();
       while(it.hasNext()){
         System.out.println(it.next().toString());
       }

       mav.addObject("getListWrite",list);
       
       mav.setViewName("getDetailWrite");

       return mav;
      
  }

  
  //테스트 이게 원래 소스
/*  @RequestMapping(value="/getDetailWrite.do")
  public ModelAndView getDetailWrite(int no, ModelAndView mav)  throws Exception {
   
   

   if(mav == null) {
     throw new Exception(no+ "번 게시글 없음");
   }
      
      //model.addAttribute("list", teacherService.list(pageNo, pageSize));
      //mav.addObject("getListWrite",list);
      //mav.addObject("getDetailWrite",list);
   
     mav.addObject("WriteDTO", no);
   
      return mav;
      
      
  }*/
  
  /*@ResponseBody
  @RequestMapping(value="/getDetailWrite.do")
  public ModelAndView getDetailWrite(int no)  throws Exception {
   
   WriteDTO wirte = WriteService.(no);

   if(mav == null) {
     throw new Exception(no+ "번 게시글 없음");
   }
      
      //model.addAttribute("list", teacherService.list(pageNo, pageSize));
      //mav.addObject("getListWrite",list);
      //mav.addObject("getDetailWrite",list);
   
     mav.addObject("WriteDTO", no);
   
      return mav;
      
      
  }
  */
  
 /*@RequestMapping(value="/getDetailWrite.do", method = {RequestMethod.GET, RequestMethod.POST})
  public ModelAndView getDetailWrite(ModelAndView mav, WriteDTO wdto) {
   
      WriteDTO mapwdto = new WriteDTO();
     mapwdto.setW_no(wdto.getW_no());
      mapwdto.setW_title(wdto.getW_title());
      mapwdto.setW_date(wdto.getW_date());
      
      System.out.printf("w_no=%s\n", wdto.getW_no());
      
      ArrayList<WriteDTO> list=(ArrayList<WriteDTO>) writeService.getListWrite();
      if(list != null) {
        System.out.println("데이터 null 아님");
        System.out.println(wdto.getW_no());
        list = writeService.getDetailWrite(wdto.getW_no());
        System.out.println(list);
      }
      
      System.out.println("getDetail");
     // System.out.println(list);   
      
         Iterator<WriteDTO> it=list.iterator();
         while(it.hasNext()){
           System.out.println(it.next().toString());
         }
      
      //System.out.println(mapwdto.getW_no());
      //System.out.println(mapwdto.getW_date());
       //mav.addObject("getListWrite",wdto);
       //mav.;
       mav.setViewName("getDetailWrite");
       return mav;
       
  
  
 }*/
  
}
 
