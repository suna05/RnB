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
	
	// 목표달성도 출력을위한 todolist의 총 갯수
	public int obtainAll(ToDoListDTO tdto)
	{
		int all = todolistService.getObtainAll(tdto);
		
		return all;
	}
	
	// 목표달성도 출력을 위한 완료된 todolist 갯수
	public int obtainComplete(ToDoListDTO tdto)
	{
		int complete = todolistService.obtainComplete(tdto);
		
		return complete;
	}
	
	// ToDoList 출력
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
	
	// ToDoList 등록
	@RequestMapping(value="register.do")
	public ModelAndView toDoListInsert(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		String[] dtoArr = tdto.getT_content().split(",");
		
		for(int i=0; i<dtoArr.length; i++)
		{
			tdto.setT_content(dtoArr[i]);
			System.out.println("추가한 todolist:"+tdto.toString());
			todolistService.insertToDoList(tdto);
		}
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("t_writer", tdto.getT_writer());
		mav.addObject("m_id",tdto.getM_id());
		return mav;
	}
	
	// ToDoList 완료 체크
	@RequestMapping(value="todolistComplete.do")
	public ModelAndView toDoListComplete(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		todolistService.completeList(tdto);
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("m_id", tdto.getM_id());
		
		return mav;
	}
	
	// ToDoList 삭제
	@RequestMapping(value="todolistDelete.do")
	public ModelAndView toDoListDelete(Locale local, ToDoListDTO tdto, ModelAndView mav)
	{
		todolistService.deleteList(tdto);
		
		mav.setViewName("redirect:todolist.do");
		mav.addObject("m_id", tdto.getM_id());
		
		return mav;
	}
}
