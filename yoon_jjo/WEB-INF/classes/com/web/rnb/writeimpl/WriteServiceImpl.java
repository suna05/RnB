package com.web.rnb.writeimpl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.photo.PhotoDTO;
import com.web.rnb.write.WriteDTO;
import com.web.rnb.writeimpl.WritePager;
import com.web.rnb.write.WriteService;

@Service
public class WriteServiceImpl implements WriteService{

	@Autowired
	private WriteDAO wdao;


	@Override
	public boolean isUpdateCount(WriteDTO wdto, HttpSession session, Cookie[] cookies, String m_id)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		boolean result=false;
		if(session.getAttribute("member")!=null) {
			if(cookies!=null) {
	  			for(int i=0;i<cookies.length;i++) {
	  				Cookie c=cookies[i];
	  				String cName=URLDecoder.decode(c.getName(),"UTF-8");
	  				if(cName.equals("write"+wdto.getW_no()+m_id)) {
	  					result=true;
	  					break;
	  				}
	  			}
	  		}
		}
		return result;
	}

	@Override
	public List<WriteDTO> getListPopular() {
		// TODO Auto-generated method stub
		return wdao.getListPopular();
	}

	@Override
	public void insertWrite(WriteDTO wdto) {
		wdao.insertWrite(wdto);
	}
	@Override
	public WriteDTO getWrite(WriteDTO wdto) {
		WriteDTO wdto2=wdao.getWrite(wdto);
		return wdto2;
	}
	@Override
	public List<WriteDTO> getListWrite(WritePager writepager) {
		List<WriteDTO>list = wdao.getListWrite(writepager);
		return list;
	}
	@Override
	public void updateWrite(WriteDTO wdto) {
		wdao.updateWrite(wdto);
	}
	@Override
	public void deleteWrite(WriteDTO wdto) {
		wdao.deleteWrite(wdto);
	}
	@Override
	public void updateCount(WriteDTO wdto) {
		wdao.updateCount(wdto);
	}
	@Override
	public int getTotalCount() {
		return wdao.getTotalCount();
	}
}