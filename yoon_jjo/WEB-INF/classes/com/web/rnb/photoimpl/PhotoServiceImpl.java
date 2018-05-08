package com.web.rnb.photoimpl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.rnb.photo.PhotoDTO;
import com.web.rnb.photo.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{
	@Autowired
	private PhotoDAO pdao;

	@Override
	public void insertPhoto(PhotoDTO pdto) {
		// TODO Auto-generated method stub
		pdao.insertPhoto(pdto);
	}

	@Override
	public boolean isUpdateCount(PhotoDTO pdto,HttpSession session,Cookie[] cookie,String m_id) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		boolean result=false;
		if(session.getAttribute("member")!=null) {
			if(cookie!=null) {
				for(int i=0;i<cookie.length;i++) {
					Cookie c=cookie[i];
					String cName=URLDecoder.decode(c.getName(),"UTF-8");
					if(cName.equals("photo"+pdto.getP_no()+m_id)) {
						result=true;
						break;
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<PhotoDTO> getListPopular() {
		// TODO Auto-generated method stub
		return pdao.getListPopular();
	}

	@Override
	public void updateCount(PhotoDTO pdto) {
		// TODO Auto-generated method stub
		pdao.updateCount(pdto);
	}

	@Override
	public List<PhotoDTO> getListPhoto(PhotoPager photoPager) {
		List<PhotoDTO>list =pdao.getListPhoto(photoPager);
		return list;
	}

	@Override
	public PhotoDTO getPhoto(PhotoDTO pdto) {
		PhotoDTO pdto2= pdao.getPhoto(pdto);
		System.out.println(pdto2.toString());
		return pdto2;
	}

	@Override
	public void deletePhoto(PhotoDTO pdto) {
		pdao.deletePhoto(pdto);
	}

	@Override
	public void updatePhoto(PhotoDTO pdto) {
		pdao.updatePhoto(pdto);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return pdao.getTotalCount();
	}



}
