package com.powermock.api.powermock.service;

import com.powermock.api.powermock.dto.OrderRequest;
import com.powermock.api.powermock.dto.OrderResponse;
import com.powermock.api.powermock.util.EmailNotificationUtil;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	public OrderResponse checkoutOrder(OrderRequest order) {

		int discountedPrice = addDiscount(order);
		order.setPrice(order.getPrice() - discountedPrice);
		String message = EmailNotificationUtil.sendEmail(order.getEmailId());
		return new OrderResponse(order, message, 200);
	}

	private int addDiscount(OrderRequest order) {

		int price = order.getPrice();
		int discountedPrice = offer();
		if (order.isDiscountable()) {
			if (order.getPrice() > 1000) {
				discountedPrice = price * 10 / 100;
			} else {
				discountedPrice = price;
			}
		} else {
			discountedPrice = price;
		}

		return discountedPrice;
	}

	public final int offer() {
		return 1000;
	}
}
