package com.web.rnb.photoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.photo.ProfilePhotoDTO;
import com.web.rnb.photo.ProfilePhotoService;

@Service
public class ProfilePhotoServiceImpl implements ProfilePhotoService {

	@Autowired
	private ProfilePhotoDAO pdao;
	
	@Transactional
	@Override
	public void insertProfilePhoto(ProfilePhotoDTO pdto) {
		// TODO Auto-generated method stub
		pdao.insertProfilePhoto(pdto);
	}

	@Override
	public ProfilePhotoDTO getProfilePhoto(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return pdao.getProfilePhoto(mdto);
	}

}
