package com.web.insideframe.service;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.boarddao.BoardDAO;
import com.web.insideframe.dto.boarddto.BoardDTO;

public class BoardDetailViewService {
	DaoFactory df=new DaoFactory();
	BoardDAO bdao=df.boardDao();
	
	public BoardDTO selectDetail(int idx){
		BoardDTO bdto=bdao.select(idx);
		return bdto;
	}
}
