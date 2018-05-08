package com.web.rnb.member;

import java.util.List;

public interface MemberService {

	void insertMember(MemberDTO mdto);

	MemberDTO getMember(MemberDTO mdto);

	void updateMember(MemberDTO mdto);
	
	void deleteMember(MemberDTO mdto);
	
	MemberDTO confirmMember(MemberDTO mdto);
	
	MemberDTO getMyPage(MemberDTO mdto);
	
	List<MemberDTO> getListMember();
}