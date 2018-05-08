package com.web.rnb.todolist;

import java.util.List;

public interface ToDoListService {
	void insertToDoList(ToDoListDTO tdto);
	
	List<ToDoListDTO> getToDoList(ToDoListDTO tdto);

	void completeList(ToDoListDTO tdto);

	void deleteList(ToDoListDTO tdto);

	int getObtainAll(ToDoListDTO tdto);

	int obtainComplete(ToDoListDTO tdto);
}
