package com.web.rnb.photoimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.photo.ProfilePhotoDTO;

@Repository("ProfilePhotoDAO")
public class ProfilePhotoDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertProfilePhoto(ProfilePhotoDTO pdto) {
		mybatis.insert("ProfilePhotoDAO.insertProfilePhoto", pdto);
	}
	public ProfilePhotoDTO getProfilePhoto(MemberDTO mdto) {
		return (ProfilePhotoDTO)mybatis.selectOne("ProfilePhotoDAO.getProfilePhoto", mdto);
	}
}
