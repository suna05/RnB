package com.web.rnb.write;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.web.rnb.writeimpl.WritePager;

public interface WriteService {
	
	void insertWrite(WriteDTO wdto);
	List<WriteDTO> getListWrite(WritePager writepager);

	void updateWrite(WriteDTO wdto);

	//상세 게시물
	WriteDTO getWrite(WriteDTO wdto);

	void deleteWrite(WriteDTO wdto);

	void updateCount(WriteDTO wdto);
	
	int getTotalCount();
	
	boolean isUpdateCount(WriteDTO wdto,HttpSession session,Cookie[] cookies,String m_id) throws UnsupportedEncodingException;
	
	public List<WriteDTO> getListPopular();
}
