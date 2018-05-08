package com.web.rnb.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.photo.PhotoDTO;
import com.web.rnb.photo.PhotoService;
import com.web.rnb.photoimpl.BoardFileUpdate;
import com.web.rnb.photoimpl.BoardFileUpload;
import com.web.rnb.photoimpl.PhotoPager;
import com.web.rnb.reply.ReplyPhotoDTO;
import com.web.rnb.reply.ReplyPhotoService;

@Controller
public class PhotoController {

	@Autowired 
	ServletContext ctx;
	@Autowired
	PhotoService bps;
	@Autowired
	BoardFileUpdate bfud;
	@Autowired
	BoardFileUpload bfu;
	@Autowired
	PhotoService photoService;
	@Autowired
	ReplyPhotoService replypService;
	/*  @Autowired
  BoardPhotoService boardPhotoService;*/


	@RequestMapping(value="/insertPhoto.do",method=RequestMethod.POST)
	public ModelAndView insertPhoto(HttpServletRequest request, @RequestParam("boardPhoto")MultipartFile multipartFile,
			PhotoDTO pdto, ModelAndView mav) {

		if(multipartFile.getOriginalFilename()!=null) {
			bfu.uploadFile(request, multipartFile, pdto);
		}
		mav.setViewName("redirect:getListPhoto.do");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/getListPopular.do")
	public List<PhotoDTO> getListPopular(ModelAndView mav) {
		List<PhotoDTO> list=photoService.getListPopular();
		return list;
	}


	@RequestMapping(value="/getListPhoto.do")
	public ModelAndView getListPhoto(PhotoDTO pdto,ModelAndView mav,PhotoPager photoPager)  {
		if(pdto.getCurPage()==0){
			pdto.setCurPage(1);
		}
		photoPager.makePaging(bps.getTotalCount(),pdto.getCurPage());
		mav.addObject("getListPhoto",bps.getListPhoto(photoPager));
		mav.addObject("pager",photoPager);
		mav.setViewName("getListPhoto");
		return mav;

	}


	//사진 게시판 상세보기

	@RequestMapping(value="/getDetailPhoto.do")
	public ModelAndView getPhoto(ModelAndView mav, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, PhotoDTO pdto,@RequestParam("curPage")int curPage,@RequestParam("m_id")String m_id) throws UnsupportedEncodingException{


		request.setAttribute("PhotoDTO", pdto);

		Cookie[] cookies=request.getCookies();
		if(photoService.isUpdateCount(pdto, session,cookies,m_id)==false) {
			Cookie c1=new Cookie(URLEncoder.encode("photo"+pdto.getP_no()+m_id,"UTF-8"),"yes");
			c1.setMaxAge(60*60*24*365);
			response.addCookie(c1);
			photoService.updateCount(pdto);
		}
		List<ReplyPhotoDTO> list=replypService.getListReply(pdto.getP_no());
		pdto=photoService.getPhoto(pdto);
		mav.addObject("curPage",curPage);
		mav.addObject("getPhoto",pdto);
		mav.addObject("getReplyPhoto",list);
		mav.setViewName("getDetailPhoto");
		return mav;

	}


	//사진 게시판 삭제
	@RequestMapping(value="/deletePhoto.do", method=RequestMethod. POST ) 
	public ModelAndView deletePhoto(PhotoDTO pdto, ModelAndView mav) {
		photoService.deletePhoto(pdto);
		mav.setViewName("redirect:getListPhoto.do");
		return mav;
	}

	//사진 게시판 업데이트
	@RequestMapping(value="/updatePhoto.do", method=RequestMethod.POST )
	public ModelAndView updatePhoto(
			HttpServletRequest request, @RequestParam("boardPhoto")MultipartFile multipartFile,
			PhotoDTO pdto, ModelAndView mav) {

		PhotoDTO pdto2=bps.getPhoto(pdto);
		if(multipartFile.getOriginalFilename()==""){
			pdto.setBp_fullpath(pdto2.getBp_fullpath());
		}else{
			if(multipartFile.getOriginalFilename()!=null) {
				bfud.uploadFile(request, multipartFile, pdto);
			}
		}

		photoService.updatePhoto(pdto);
		mav.setViewName("redirect:getListPhoto.do");
		return mav;
	}
}
