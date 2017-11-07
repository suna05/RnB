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
		int curPage=Integer.parseInt(request.getParameter("page")); //���� ��������ȣ

		PagingService ps=new PagingService();
		Paging pg=ps.paging(); //����¡�κ� �������� �� paging ��ü �޾ƿ���
		
		ArrayList<BoardDTO> blist=ps.getBoardList(curPage); //�������� ���� �Խ��� �ҷ�����

		request.setAttribute("paging",pg);
		request.setAttribute("boardlist",blist);
	}

}
