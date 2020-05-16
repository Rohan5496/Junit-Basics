package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

//TodoBusinessImpl is System Under Test
// TodoService is Dependency
public class TodoBusinessImpl {

	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<>();
		List<String> retrievedTodos = todoService.retrieveTodos(user);
		for(String todo : retrievedTodos) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	
	
	
	
}
