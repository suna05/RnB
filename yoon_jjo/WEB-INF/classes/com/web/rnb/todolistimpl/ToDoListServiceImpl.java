package com.web.rnb.todolistimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.rnb.todolist.ToDoListDTO;
import com.web.rnb.todolist.ToDoListService;

@Service
public class ToDoListServiceImpl implements ToDoListService {

	@Autowired
	private ToDoListDAO tdao;
	
	
	@Override
	public void insertToDoList(ToDoListDTO tdto) 
	{
		tdao.insertToDoList(tdto);
	}

	@Override
	public List<ToDoListDTO> getToDoList(ToDoListDTO tdto)
	{
		List<ToDoListDTO> list = tdao.getToDoList(tdto);
		
		return list;
	}

	@Override
	public void completeList(ToDoListDTO tdto)
	{
		tdao.completeList(tdto);
	}

	@Override
	public void deleteList(ToDoListDTO tdto)
	{
		tdao.deleteList(tdto);
	}

	@Override
	public int getObtainAll(ToDoListDTO tdto)
	{
		int all = tdao.getObtainAll(tdto);
		
		return all;
	}

	@Override
	public int obtainComplete(ToDoListDTO tdto)
	{
		int complete = tdao.getObtainComplete(tdto);
		
		return complete;
	}

}
