package com.web.rnb.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.reply.ReplyDTO;
import com.web.rnb.reply.ReplyService;
import com.web.rnb.write.WriteDTO;
import com.web.rnb.write.WriteService;
import com.web.rnb.writeimpl.WritePager;

@Controller
public class WriteController {

	@Autowired 
	WriteService writeService;

	@Autowired
	WritePager writePager;
	
	@Autowired
	ReplyService replyService;
	@RequestMapping(value="/insertWrite.do", method=RequestMethod.POST)
	public ModelAndView insertWrite(WriteDTO wdto, ModelAndView mav, HttpSession session) {

		writeService.insertWrite(wdto);
		mav.setViewName("redirect:getListWrite.do");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/getListPopularWrite.do")
	public List<WriteDTO> getListPopularWrite(){
		List<WriteDTO> list=writeService.getListPopular();
		return list;
	}
	@RequestMapping(value="/getListWrite.do")
	public ModelAndView getListWrite(WriteDTO wdto, WritePager writePager, ModelAndView mav, HttpSession session)  {
		if(wdto.getCurPage()==0){
			wdto.setCurPage(1);
		}
		writePager.makePaging(writeService.getTotalCount(),wdto.getCurPage());
		java.util.List<WriteDTO> list=writeService.getListWrite(writePager);
		mav.addObject("writeList",list);
		mav.addObject("pager",writePager);
		mav.setViewName("getListWrite");

		return mav;

	}

	//게시글 상세 보기
	@RequestMapping(value="/getDetailWrite.do", method=RequestMethod.GET)
	public ModelAndView getWrite(/*@PathVariable String seq*/HttpServletRequest request,
			HttpServletResponse response, ModelAndView mav, WriteDTO wdto, HttpSession session,@RequestParam("curPage")int curPage,
			@RequestParam("m_id")String m_id)throws UnsupportedEncodingException   {

		request.setAttribute("WriteDTO", wdto);

		Cookie[] cookies=request.getCookies();
		if(writeService.isUpdateCount(wdto, session, cookies, m_id)==false) {
			Cookie c1=new Cookie(URLEncoder.encode("write"+wdto.getW_no()+m_id,"UTF-8"),"yes");
			c1.setMaxAge(60*60*24*365);
	    	response.addCookie(c1);
	    	writeService.updateCount(wdto);
		}
		List<ReplyDTO> list=replyService.getListReply(wdto.getW_no());
		wdto=writeService.getWrite(wdto);
		mav.addObject("curPage",curPage);
		mav.addObject("getDetail",wdto);
		mav.addObject("getReply",list);
		mav.setViewName("getDetailWrite");
		return mav;
	}
	
	@RequestMapping(value="/getDetailPopularWrite.do", method=RequestMethod.GET)
	public ModelAndView getPopularWrite(/*@PathVariable String seq*/HttpServletRequest request,
			HttpServletResponse response, ModelAndView mav, WriteDTO wdto, HttpSession session,
			@RequestParam("m_id")String m_id)throws UnsupportedEncodingException   {

		request.setAttribute("WriteDTO", wdto);

		Cookie[] cookies=request.getCookies();
		if(writeService.isUpdateCount(wdto, session, cookies, m_id)==false) {
			Cookie c1=new Cookie(URLEncoder.encode("write"+wdto.getW_no()+m_id,"UTF-8"),"yes");
			c1.setMaxAge(60*60*24*365);
	    	response.addCookie(c1);
	    	writeService.updateCount(wdto);
		}
		wdto=writeService.getWrite(wdto);
		mav.addObject("getDetail",wdto);
		mav.setViewName("getDetailPopularWrite");
		return mav;
	}

	//글 업데이트
	@RequestMapping(value="/updateWrite.do", method=RequestMethod.POST )
	public ModelAndView updateWrite(WriteDTO wdto, ModelAndView mav) {

		writeService.updateWrite(wdto);
		mav.setViewName("redirect:getListWrite.do");
		return mav;
	}

	//글 삭제
	@RequestMapping(value="/deleteWrite.do", method=RequestMethod. POST)
	public ModelAndView deleteWrite(WriteDTO wdto, ModelAndView mav) {
		writeService.deleteWrite(wdto);
		mav.setViewName("redirect:getListWrite.do");
		return mav;
	}

}
