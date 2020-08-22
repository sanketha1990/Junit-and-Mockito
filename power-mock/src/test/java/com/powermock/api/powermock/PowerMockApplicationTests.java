package com.powermock.api.powermock;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.powermock.api.powermock.dto.OrderRequest;
import com.powermock.api.powermock.service.OrderService;
import com.powermock.api.powermock.util.EmailNotificationUtil;

@SpringBootTest
class PowerMockApplicationTests {

	@Mock
	OrderService orderService;

	OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "test@gmail.com", true);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(EmailNotificationUtil.class);
	}

	public void testPlaceOrder() {
		//Given
		String emailId="test@gmail.com";
		PowerMockito.mockStatic(EmailNotificationUtil.class);
		
		//When
		when(EmailNotificationUtil.sendEmail(emailId)).thenReturn("success");
		
		//then
		String message=EmailNotificationUtil.sendEmail(emailId);
		assertEquals("success", message);
	

	}

}
