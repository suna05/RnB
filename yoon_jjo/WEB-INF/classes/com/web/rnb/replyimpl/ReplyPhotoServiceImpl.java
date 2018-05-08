package com.web.rnb.replyimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.reply.ReplyPhotoDTO;
import com.web.rnb.reply.ReplyPhotoService;

@Service
public class ReplyPhotoServiceImpl implements  ReplyPhotoService {

	@Autowired
	private ReplyPhotoDAO rdao;

	@Override
	public void insertReply(ReplyPhotoDTO rdto) {
		rdao.insertReply(rdto);
	}

	@Override
	public List<ReplyPhotoDTO> getListReply(int p_no) {
		List<ReplyPhotoDTO> list=rdao.getListReply(p_no);
		return list;

	}

	@Override
	public void updatePhotoReply(ReplyPhotoDTO rdto) {
		rdao.updatePhotoReply(rdto);
	}
	
	   @Override
	    public void deletePhotoReply(ReplyPhotoDTO rdto) {
	        rdao.deletePhotoReply(rdto);
	    }
	    
	    

}