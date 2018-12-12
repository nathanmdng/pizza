package com.pizza.discount;

import com.pizza.domain.order.Receipt;

public class FreeDelivery implements Discount {

	@Override
	public Receipt apply(Receipt pricing) {
		double discount = pricing.getDelivery();
		pricing.setDiscount(discount);
		return pricing;
	}

}
