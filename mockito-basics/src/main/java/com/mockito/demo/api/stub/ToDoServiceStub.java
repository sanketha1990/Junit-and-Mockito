package com.mockito.demo.api.stub;

import java.util.Arrays;
import java.util.List;

import com.mockito.demo.api.ToDoService;

public class ToDoServiceStub implements ToDoService {

	@Override
	public List<String> retriveToDoList(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Learn Spring boot", "Learn Spring", "Learn Docker", "Learn Kubernetis");

	}

}
