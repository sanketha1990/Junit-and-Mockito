package com.mockito.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestList {

	@Test
	void testListSizeMock() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2, list.size());
	}

	@Test
	void testListReturnMultipleValues() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, list.size());
		assertEquals(3, list.size());
		assertEquals(3, list.size());
	}

	@Test
	void testListGet() {
		List list = mock(List.class);
		when(list.get(0)).thenReturn("Sanketh").thenReturn("CR");
		assertEquals("Sanketh", list.get(0));
		assertEquals("CR", list.get(0));
		assertEquals("CR", list.get(0));
		assertEquals(null, list.get(1)); // Nice mock
	}

	@Test
	void testListGetNiceMock() {
		List list = mock(List.class);

		// Nice mock going to default value
		assertEquals(null, list.get(0));// Nice mock
		assertEquals(null, list.get(1)); // Nice mock
	}

	@Test
	void testListAnyInt() {
		List list = mock(List.class);

		// Matchers defined by Mockito anyInt(), anyString() etc
		when(list.get(anyInt())).thenReturn("Sanketh");
		assertEquals("Sanketh", list.get(0));
		assertEquals("Sanketh", list.get(1));
		assertEquals("Sanketh", list.get(2));
		assertEquals("Sanketh", list.get(3));
	}

	@Test
	void testListThrowException() {
		List list = mock(List.class);

		// Matchers defined by Mockito anyInt(), anyString() etc

		when(list.get(anyInt())).thenReturn(RuntimeException.class);
		assertThrows(RuntimeException.class,()->list.get(0));
	}

}
