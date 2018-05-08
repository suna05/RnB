package com.web.rnb.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;
import com.web.rnb.photo.PhotoService;
import com.web.rnb.todolist.ToDoListDTO;
import com.web.rnb.todolist.ToDoListService;

@Controller
public class CommonController {

	@Autowired
	MemberService memberService;
	@Autowired
	PhotoService photoService;
	@Autowired
	ToDoListService toDoListService;
	
	@RequestMapping(value="/index.do")
	public ModelAndView index(ModelAndView mav,HttpSession session) {
		mav.setViewName("index");
		
		mav.addObject("memberList",memberService.getListMember());
		return mav;
	}
	
	@RequestMapping(value="/home.do")
	public ModelAndView home(ModelAndView mav,HttpServletRequest request) {
		String str=request.getHeader("user-agent");
		boolean mobile1=str.matches(".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|"
				+"|Windows Phone|WebOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
		boolean mobile2=str.matches(".*(LG|SAMSUNG|Samsung).*");
		if(mobile1 || mobile2) {
			mav.setViewName("enterMobile");
		}
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping(value="/photo.do")
	  public ModelAndView photo(ModelAndView mav) {
	      mav.setViewName("photo");
	      return mav;
	  }
	 
	 @RequestMapping(value="/photoList.do")
	 public ModelAndView photoList(ModelAndView mav) {
	     mav.setViewName("photolist");
	     return mav;
	 }
	 
	 @RequestMapping(value="/photoDetail.do")
	 public ModelAndView photoDetail(ModelAndView mav) {
	     mav.setViewName("photodetail");
	     return mav;
	 }
	 
	 
	 @RequestMapping(value="/write.do")
	 public ModelAndView write(ModelAndView mav) {
	     mav.setViewName("write");
	     return mav;
	 }
	 
	 @RequestMapping(value="/writelist.do")
	 public ModelAndView writeList(ModelAndView mav) {
	     mav.setViewName("writelist");
	     return mav;
	 }
	 
	 
	 @RequestMapping(value="/writedetail.do")
	 public ModelAndView writeDetailList(ModelAndView mav) {
	     mav.setViewName("writedetail");
	     return mav;
	 }

	 @RequestMapping(value="/reply.do")
	 public ModelAndView reply(ModelAndView mav) {
	     mav.setViewName("reply");
	     return mav;
	 }
	 
	 @RequestMapping(value="/replylist.do")
	 public ModelAndView replyList(ModelAndView mav) {
	     mav.setViewName("replylist");
	     return mav;
	 }
	 
}
