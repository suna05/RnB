package com.web.rnb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	
	@RequestMapping(value="/insertMember.do",method=RequestMethod.POST)
	public ModelAndView insertMember(MemberDTO mdto,ModelAndView mav) {
		System.out.println("MemberController.insertMember() ȣ��");
		memberService.insertMember(mdto);
		if(mdto==null) System.out.println("���̽������Ϳ���");
		mav.setViewName("redirect:index.do");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="/login.do")
	public int login(MemberDTO mdto,HttpSession session) {
		System.out.println("MemberController.login() ȣ��");
		MemberDTO confirmMember=memberService.confirmMember(mdto);
		int result=0;
		if(confirmMember!=null) {
			if(mdto.getM_pw().equals(confirmMember.getM_pw())) {
				session.setAttribute("member",confirmMember);
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
	public int idCheck(MemberDTO mdto,ModelAndView mav) {
		System.out.println("MemberController.idCheck()");
		int result=0;
		MemberDTO member=memberService.getMember(mdto);
		if(member!=null){
			result=1;
		}
		return result;
	}
	@RequestMapping(value="logout.do")
	public ModelAndView logout(ModelAndView mav,HttpSession session) {
		System.out.println("MemberController.logout() ȣ��");
		session.invalidate();
		mav.setViewName("redirect:index.do");
		return mav;
	}
}
