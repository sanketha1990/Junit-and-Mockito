package com.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(PowerMockRunner.class)
class PowerMockConstructorTest {

	@InjectMocks
	PowerMock powerMock;
	
	private static final int INITIALIZE = 100;

	@Test
	void testGetList() throws Exception {
		ArrayList mockList=mock(ArrayList.class);
		
		when(mockList.size()).thenReturn(INITIALIZE);
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int size=powerMock.getList();
		
		assertEquals(INITIALIZE, size);
	}

}
