package com.intuit.pizza.discount;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.service.PricingService;

public interface Discount {

	double apply(PricingService pricingService, Order order);
	
}
