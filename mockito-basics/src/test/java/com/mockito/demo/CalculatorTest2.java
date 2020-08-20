package com.mockito.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mockito.demo.service.CalculatorService;

class CalculatorTest2 {

	@Mock
	CalculatorService service;

	@InjectMocks
	Calculator cal;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testPerform() {
		when(service.perform(2, 2)).thenReturn(8);
		assertEquals(8, cal.perform(2, 2));
	}

}
