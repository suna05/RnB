package com.web.rnb.todolistimpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.rnb.todolist.ToDoListDTO;

@Repository("ToDoListDAO")
public class ToDoListDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertToDoList(ToDoListDTO tdto) 
	{
		
		mybatis.insert("ToDoListDAO.insertToDoList", tdto);
	}
	
	public List<ToDoListDTO> getToDoList(ToDoListDTO tdto)
	{
		
		return mybatis.selectList("ToDoListDAO.getToDoList", tdto);
	}

	public void completeList(ToDoListDTO tdto)
	{
		
		mybatis.update("ToDoListDAO.completeList", tdto);
	}

	public void deleteList(ToDoListDTO tdto) 
	{
		
		mybatis.delete("ToDoListDAO.deleteList", tdto);
	}

	public int getObtainAll(ToDoListDTO tdto) 
	{
		
		return mybatis.selectOne("ToDoListDAO.getObtainAll", tdto);
	}

	public int getObtainComplete(ToDoListDTO tdto)
	{
		
		return mybatis.selectOne("ToDoListDAO.getObtainComplete", tdto);
	}
}
