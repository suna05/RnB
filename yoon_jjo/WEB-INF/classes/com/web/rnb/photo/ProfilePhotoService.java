package com.web.rnb.photo;

import com.web.rnb.member.MemberDTO;

public interface ProfilePhotoService {

	void insertProfilePhoto(ProfilePhotoDTO pdto);

	ProfilePhotoDTO getProfilePhoto(MemberDTO mdto);

}