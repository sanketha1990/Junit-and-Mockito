package com.mockito.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mockito.demo.api.ToDoService;

public class ToDoServiceImpl{
	private ToDoService service;

	public ToDoServiceImpl(ToDoService service) {
		this.service = service;
	}

	public ToDoServiceImpl() {
		System.out.println("No arg constructor");
	}
	public List<String> retriveToDoListPerUser(String user) {
		List<String> filterTodos = new ArrayList<String>();
		List<String> todo = service.retriveToDoList(user);

		for (String td : todo) {
			if (td.contains("Spring")) {
				filterTodos.add(td);
			}
		}
		return filterTodos;
	}
}
