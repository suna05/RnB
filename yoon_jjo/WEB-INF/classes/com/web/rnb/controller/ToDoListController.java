package com.web.rnb.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.rnb.todolist.ToDoListDTO;
import com.web.rnb.todolist.ToDoListService;

@Controller
public class ToDoListController {
	@Autowired
	ToDoListService todolistService;
	
	// ��ǥ�޼��� ��������� todolist�� �� ����
	public int obtainAll(ToDoListDTO tdto)
	{
		int all = todolistService.getObtainAll(tdto);
		
		return all;
	}
	
	// ��ǥ�޼��� ����� ���� �Ϸ�� todolist ����
	public int obtainComplete(ToDoListDTO tdto)
	{
		int complete = todolistService.obtainComplete(tdto);
		
		return complete;
	}
	
	// ToDoList ���
	@RequestMapping(value="todolist.do")
	public ModelAndView toDoListView(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		System.out.println("m_id:"+tdto.getM_id());
		List<ToDoListDTO> list = todolistService.getToDoList(tdto);
		
		double all = obtainAll(tdto);
		double complete = obtainComplete(tdto);
		int rate = (int)(complete / all * 100);
		
		mav.setViewName("todolist");
		
		mav.addObject("list", list);
		mav.addObject("rate", rate);
		
		return mav;
	}
	
	// ToDoList ���
	@RequestMapping(value="register.do")
	public ModelAndView toDoListInsert(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		String[] dtoArr = tdto.getT_content().split(",");
		
		for(int i=0; i<dtoArr.length; i++)
		{
			tdto.setT_content(dtoArr[i]);
			System.out.println("�߰��� todolist:"+tdto.toString());
			todolistService.insertToDoList(tdto);
		}
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("t_writer", tdto.getT_writer());
		mav.addObject("m_id",tdto.getM_id());
		return mav;
	}
	
	// ToDoList �Ϸ� üũ
	@RequestMapping(value="todolistComplete.do")
	public ModelAndView toDoListComplete(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		todolistService.completeList(tdto);
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("m_id", tdto.getM_id());
		
		return mav;
	}
	
	// ToDoList ����
	@RequestMapping(value="todolistDelete.do")
	public ModelAndView toDoListDelete(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		todolistService.deleteList(tdto);
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("m_id", tdto.getM_id());
		
		return mav;
	}
}
