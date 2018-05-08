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
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.message.stream.StreamAttachment;
import com.sun.xml.internal.ws.util.StringUtils;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.photo.BoardPhotoDTO;
import com.web.rnb.reply.ReplyDTO;
import com.web.rnb.reply.ReplyService;
import com.web.rnb.write.WriteDTO;
import com.web.rnb.write.WriteService;
import com.web.rnb.writeimpl.WriteDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ReplyController {
  
  @Autowired 
  ReplyService replyService;
 
  @RequestMapping(value="/insertReply.do")
  public ModelAndView insertReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage,@RequestParam("w_no")int w_no, ReplyDTO rdto, ModelAndView mav, HttpSession session) {
	  rdto.setW_no(w_no);
	  replyService.insertReply(rdto);
	  List<ReplyDTO> list=replyService.getListReply(w_no);
	  mav.addObject("m_id",m_id);
	  mav.addObject("curPage",curPage);
	  mav.setViewName("redirect:getDetailWrite.do?w_no="+w_no);
	  return mav;
  }
  
  
  @RequestMapping(value="/updateReply.do",  method={RequestMethod.POST, RequestMethod.GET} )
  public ModelAndView updateReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage, ReplyDTO rdto, ModelAndView mav) {
    replyService.updateReply(rdto);
    mav.addObject("m_id",m_id);
	mav.addObject("curPage",curPage);
    mav.setViewName("redirect:getDetailWrite.do?w_no="+rdto.getW_no());
    return mav;
  }
  
  
  @RequestMapping(value="/deleteReply.do", method={RequestMethod.POST, RequestMethod.GET}) 
  public ModelAndView deleteReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage,ReplyDTO rdto, ModelAndView mav) {
      replyService.deleteReply(rdto);
      mav.addObject("m_id",m_id);
      mav.addObject("curPage",curPage);
      mav.setViewName("redirect:getDetailWrite.do?w_no="+rdto.getW_no());
      return mav;
  }
  
  
  
}
  
 
