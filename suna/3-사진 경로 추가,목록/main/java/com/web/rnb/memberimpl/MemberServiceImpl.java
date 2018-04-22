package com.web.rnb.memberimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("MemberServiceImpl() 객체 생성");
	}
	@Override
	public void updateMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.updateMember() 호출");
		mdao.updateMember(mdto);
	}
	@Override
	public void deleteMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.deleteMember() 호출");
		mdao.deleteMember(mdto);
	}
	@Override
	public void insertMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.insertMember() 호출");
		mdao.insertMember(mdto);
	}

	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.getMember() 호출");
		return mdao.getMember(mdto);
	}
	@Override
	public MemberDTO confirmMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl.confirmMember() 호출");
		return mdao.getMember(mdto);
	}
	
}
