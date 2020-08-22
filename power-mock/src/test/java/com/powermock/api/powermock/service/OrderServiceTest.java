package com.powermock.api.powermock.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.powermock.api.powermock.dto.OrderRequest;
import com.powermock.api.powermock.dto.OrderResponse;
import com.powermock.api.powermock.util.EmailNotificationUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.powermock.api.powermock.service.*")
class OrderServiceTest {

	@Mock
	OrderService orderService;

	OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "test@gmail.com", true);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(EmailNotificationUtil.class);
	}

	// @Test
	public void testStaticMethod() {
		// Given
		String emailId = "test@gmail.com";
		PowerMockito.mockStatic(EmailNotificationUtil.class);

		// When
		when(EmailNotificationUtil.sendEmail(emailId)).thenReturn("success");

		// then
		String message = EmailNotificationUtil.sendEmail(emailId);
		assertEquals("success", message);
	}

	@Test
	public void testPrivateMethod() throws Exception {

		// When
		OrderService spy = Mockito.spy(orderService);
		doReturn(1000).when(spy, "addDiscount", ArgumentMatchers.any());

		// Then
		OrderResponse response = spy.checkoutOrder(request);
		int price = response.getResponse().getPrice();

		assertEquals(9000, price);
	}

	@Test
	public void testFinalMethod() throws Exception {

		// When
		OrderService spy = Mockito.spy(orderService);
		doReturn(1000).when(spy,"addDiscount",ArgumentMatchers.any());
		doReturn(1000).when(spy, "offer", ArgumentMatchers.any());

		// Then
		OrderResponse response = spy.checkoutOrder(request);
		int price = response.getResponse().getPrice();

		assertEquals(8000, price);
	}

}
