package com.web.rnb.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.reply.ReplyPhotoDTO;
import com.web.rnb.reply.ReplyPhotoService;


@Controller
public class PhotoReplyController {

	@Autowired 
	ReplyPhotoService replyphotoService;

	@RequestMapping(value="/insertPhotoReply.do", method=RequestMethod.POST)
	public ModelAndView insertReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage,@RequestParam("p_no")int p_no, ReplyPhotoDTO rdto, ModelAndView mav, HttpSession session) {
		rdto.setP_no(p_no);
		System.out.println("게시판번호:"+rdto.getP_no()); 
		replyphotoService.insertReply(rdto);
		List<ReplyPhotoDTO> list = replyphotoService.getListReply(p_no);
		Iterator<ReplyPhotoDTO> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		mav.addObject("m_id",m_id);
		mav.addObject("curPage",curPage);
		mav.addObject("getReplyp",list);
		mav.setViewName("redirect:getDetailPhoto.do?p_no="+p_no);
		return mav;
	}

	@RequestMapping(value="/updatePhotoReply.do"/*,   method={RequestMethod.POST, RequestMethod.GET} */)
	public ModelAndView updatePhotoReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage,ReplyPhotoDTO rdto, ModelAndView mav) {
		replyphotoService.updatePhotoReply(rdto);
		mav.addObject("m_id",m_id);
		mav.addObject("curPage",curPage);
		mav.setViewName("redirect:getDetailPhoto.do?p_no="+rdto.getP_no());
		return mav;
	}
	
	@RequestMapping(value="/deletePhotoReply.do" ) 
    public ModelAndView deletePhotoReply(@RequestParam("m_id")String m_id,@RequestParam("curPage")int curPage,ReplyPhotoDTO rdto, ModelAndView mav) {
		replyphotoService.deletePhotoReply(rdto);
		mav.addObject("m_id",m_id);
		mav.addObject("curPage",curPage);
		mav.setViewName("redirect:getDetailPhoto.do?p_no="+rdto.getP_no());
		return mav;
    }
	
}