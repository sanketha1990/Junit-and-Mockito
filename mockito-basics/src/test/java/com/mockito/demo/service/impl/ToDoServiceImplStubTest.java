package com.mockito.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.demo.api.ToDoService;
import com.mockito.demo.api.stub.ToDoServiceStub;

class ToDoServiceImplStubTest {

	@Test
	void testRetriveToDoRelatedToSpring() {
		ToDoService service = new ToDoServiceStub();
		ToDoServiceImpl serviceImpl = new ToDoServiceImpl(service);
		List<String> result = serviceImpl.retriveToDoListPerUser("DUMMY");
		assertEquals(2, result.size());
	}

}
