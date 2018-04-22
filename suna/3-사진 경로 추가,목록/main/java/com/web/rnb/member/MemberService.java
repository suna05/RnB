package com.web.rnb.member;

public interface MemberService {

	void insertMember(MemberDTO mdto);

	MemberDTO getMember(MemberDTO mdto);

	void updateMember(MemberDTO mdto);
	
	void deleteMember(MemberDTO mdto);
	
	MemberDTO confirmMember(MemberDTO mdto);
}