package com.intuit.pizza.discount;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.service.PricingService;

public class FreeDelivery implements Discount {

	@Override
	public double apply(PricingService pricingService, Order order) {
		double fullPrice = pricingService.calculatePrice(order);
		return fullPrice - pricingService.getDeliveryCost();
	}

}
