package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.boarddto.BoardDTO;
import com.web.insideframe.paging.Paging;
import com.web.insideframe.service.memberservice.PagingService;

public class BoardListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int curPage=Integer.parseInt(request.getParameter("page")); //현재 페이지번호

		PagingService ps=new PagingService();
		Paging pg=ps.paging(); //페이징부분 로직수행 후 paging 객체 받아오기
		
		ArrayList<BoardDTO> blist=ps.getBoardList(curPage); //페이지에 따른 게시판 불러오기

		request.setAttribute("paging",pg);
		request.setAttribute("boardlist",blist);
	}

}
