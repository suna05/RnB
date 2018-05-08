package com.web.rnb.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.member.MemberAndPhotoDTO;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;
import com.web.rnb.photo.ProfilePhotoDTO;
import com.web.rnb.photo.ProfilePhotoService;
import com.web.rnb.photoimpl.ProfileFileUpload;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProfileFileUpload pfu;
	@Autowired
	private ProfilePhotoService pps;
	
	@RequestMapping(value="/insertMember.do",method=RequestMethod.POST)
	public ModelAndView insertMember(HttpServletRequest request, @RequestParam("profilePhoto")MultipartFile multipartFile,Locale locale,MemberDTO mdto,ModelAndView mav) {
		logger.info("insertMember() 호출", locale);
		ProfilePhotoDTO pdto=new ProfilePhotoDTO();
		memberService.insertMember(mdto);
		if(multipartFile.getOriginalFilename()=="") {
			pdto.setM_id(mdto.getM_id());
			//사진이 없을때 디폴트 사진 들어가는데 문제 해결해야함
			pdto.setPp_fullpath("resources/images/no_avatar"+"_"+System.currentTimeMillis()+".jpg");
			pps.insertProfilePhoto(pdto);
		}
		else if(multipartFile!=null) {
			if(pfu.uploadFile(request, multipartFile,mdto)) {
				System.out.println("파일 업로드 성공");
			}else {
				System.out.println("파일 업로드 실패");
			}
		}
		mav.setViewName("redirect:home.do");
		return mav;
	}
	@RequestMapping
	public ModelAndView updateMember(ModelAndView mav,MemberDTO mdto,@RequestParam("changePw1")String changePw) {
		mdto.setM_pw(changePw);
		memberService.updateMember(mdto);
		mav.setViewName("redirect:home.do");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="/login.do")
	public int login(Locale locale,MemberDTO mdto,HttpSession session) {
		logger.info("login() 호출", locale);
		MemberDTO confirmMember=memberService.confirmMember(mdto);
		ProfilePhotoDTO pdto=pps.getProfilePhoto(mdto);
		int result=0;
		if(confirmMember!=null) {
			if(mdto.getM_pw().equals(confirmMember.getM_pw())) {
				session.setAttribute("member",confirmMember);
				if(!pdto.getPp_fullpath().contains("no_avatar")) {
					//원래코드
					/*pdto.setPp_fullpath(pdto.getPp_fullpath().substring(56));*/
					
					pdto.setPp_fullpath(pdto.getPp_fullpath().substring(30));
					session.setAttribute("memberProfile", pdto);
				}else {
					String pullpath=pdto.getPp_fullpath();
					String front=pullpath.substring(0,27);
					String extension=pullpath.substring(pullpath.indexOf("."));
					pdto.setPp_fullpath(front+extension);
					session.setAttribute("memberProfile", pdto);
				}
			}else {
				result=1;
			}
		}else {
			result=1;
		}
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/checkId.do")
	public int idCheck(Locale locale,MemberDTO mdto,ModelAndView mav) {
		logger.info("idCheck() 호출", locale);
		int result=0;
		MemberDTO member=memberService.getMember(mdto);
		if(member!=null){
			result=1;
		}
		return result;
	}
	@RequestMapping(value="logout.do")
	public ModelAndView logout(Locale locale,ModelAndView mav,HttpSession session) {
		logger.info("logout() 호출", locale);
		session.invalidate();
		mav.setViewName("redirect:index.do");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="myPage.do")
	public MemberAndPhotoDTO myPage(Locale locale,ModelAndView mav,HttpSession session) {
		logger.info("myPage() 호출",locale);
		MemberDTO mdto = null;
		ProfilePhotoDTO pdto = null;
		if(session.getAttribute("member") instanceof MemberDTO) {
			mdto=(MemberDTO)session.getAttribute("member");
			pdto=pps.getProfilePhoto(mdto);
		}
		mdto= memberService.getMyPage(mdto);
		MemberAndPhotoDTO mapdto=new MemberAndPhotoDTO();
		mapdto.setM_id(mdto.getM_id());
		mapdto.setM_address(mdto.getM_address());
		mapdto.setM_birth(mdto.getM_birth());
		mapdto.setM_name(mdto.getM_name());
		mapdto.setM_phone(mdto.getM_phone());
		mapdto.setM_pw(mdto.getM_pw());
		if(pdto.getPp_fullpath().contains("no_avatar")) {
			mapdto.setPp_fullpath(pdto.getPp_fullpath());
		}else {
			mapdto.setPp_fullpath(pdto.getPp_fullpath().substring(30));
			/*mapdto.setPp_fullpath(pdto.getPp_fullpath().substring(56));*/
		}
		mapdto.setPwConfirm(mdto.getPwConfirm());
		return mapdto;
	}
}
