package com.web.rnb.memberimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.rnb.controller.MemberController;
import com.web.rnb.member.MemberDTO;
import com.web.rnb.member.MemberService;
import com.web.rnb.photo.ProfilePhotoService;
import com.web.rnb.photoimpl.ProfileFileUpload;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO mdao;
	
	@Override
	public void updateMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		mdao.updateMember(mdto);
	}
	@Override
	public void deleteMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		mdao.deleteMember(mdto);
	}
	@Override
	public void insertMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		mdao.insertMember(mdto);
	}

	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.getMember(mdto);
	}
	@Override
	public MemberDTO confirmMember(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.getMember(mdto);
	}
	@Override
	public MemberDTO getMyPage(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return mdao.getMember(mdto);
	}
	@Override
	public List<MemberDTO> getListMember() {
		// TODO Auto-generated method stub
		return mdao.getListMember();
	}
	
}
