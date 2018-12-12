package com.pizza.discount;

import com.pizza.domain.order.Receipt;

public class HalfPrice implements Discount {

	@Override
	public Receipt apply(Receipt pricing) {
		double fullPrice = pricing.getTotal();
		pricing.setDiscount(fullPrice * 0.5);
		return pricing;
	}

}
