package com.web.rnb.photoimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.web.rnb.member.MemberDTO;
import com.web.rnb.photo.ProfilePhotoDTO;
import com.web.rnb.photo.ProfilePhotoService;

@Component
public class ProfileFileUpload {
	@Autowired
	ProfilePhotoService profilePhotoService;
	public boolean uploadFile(HttpServletRequest request,MultipartFile multipartFile,MemberDTO mdto) {
		
		boolean result=false;
		//�ڵ峻���� ���ؽ�Ʈ�� �����θ� ������ ������ ������ ��θ� �ٿ��ش�. ��, ������ ����� ��ġ�̴�.
		//�����ڵ�
		/*String savePath ="C:\\Users\\������\\eclipse-workspace\\yoon_jjo\\src\\main\\webapp\\resources\\profilePhoto";*/
		
		String savePath="/var/lib/tomcat8/webapps/ROOT/resources/profilePhoto"; //yoon_jjo
		//������ �����̸� filename.jpg
		String originalFileName=multipartFile.getOriginalFilename();
		System.out.println(originalFileName);
		//filename (Ȯ���ڸ� ������)
		String onlyFileName=originalFileName.substring(0, originalFileName.indexOf("."));
		System.out.println(onlyFileName);
		//.jpg Ȯ���ڸ�
		String extension=originalFileName.substring(originalFileName.indexOf("."));
		System.out.println(extension);
		//�̸� �ߺ������� ���� RENAME ��¥�� ���ϸ�ڿ� �ٿ��ش�.
		String rename=onlyFileName+"_"+System.currentTimeMillis()+extension;
		System.out.println(rename);
		//��ο� ���ϸ��� ������ fullPath
		
		//�����ڵ�
		/*String fullPath=savePath+"\\"+rename;*/
		
		String fullPath=savePath+"/"+rename;
		System.out.println(fullPath);
		
		ProfilePhotoDTO pdto=new ProfilePhotoDTO();
		pdto.setM_id(mdto.getM_id());
		pdto.setPp_fullpath(fullPath);
		System.out.println(pdto.toString());
		
		if(!multipartFile.isEmpty()) {
			try {
				byte[] bytes=multipartFile.getBytes();
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				bos.write(bytes);
				bos.close();
				result=true;
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
				return result;
			}
		}else {
			//������ ������
		}
		profilePhotoService.insertProfilePhoto(pdto);
		return result;
	}
}
