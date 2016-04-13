package com.intuit.pizza.discount;

import com.intuit.pizza.domain.order.Receipt;

public class FreeDelivery implements Discount {

	@Override
	public Receipt apply(Receipt pricing) {
		double discount = pricing.getDelivery();
		pricing.setDiscount(discount);
		return pricing;
	}

}
