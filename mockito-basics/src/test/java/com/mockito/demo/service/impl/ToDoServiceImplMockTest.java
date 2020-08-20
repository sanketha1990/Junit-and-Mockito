package com.mockito.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.demo.api.ToDoService;

class ToDoServiceImplMockTest {

	@Test
	void testRetriveToDoRelatedToSpring() {
		ToDoService service = mock(ToDoService.class);
		ToDoServiceImpl serviceImpl = new ToDoServiceImpl(service);

		List<String> toDoList = Arrays.asList("Learn Spring boot", "Learn Spring", "Learn Docker", "Learn Kubernetis");
		when(service.retriveToDoList("DUMMY")).thenReturn(toDoList);
		List<String> result = serviceImpl.retriveToDoListPerUser("DUMMY");
		assertEquals(2, result.size());
	}

}
