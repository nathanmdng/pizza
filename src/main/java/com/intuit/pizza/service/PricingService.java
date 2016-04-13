package com.intuit.pizza.service;

import org.springframework.stereotype.Service;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.domain.order.OrderType;
import com.intuit.pizza.domain.order.Receipt;
import com.intuit.pizza.domain.pizza.Pizza;

@Service
public class PricingService {

	private static final double TAX_RATE = 0.12;
	private static final double DELIVERY_COST = 5;
	
	public Receipt calculatePrice(Order order) {
		Receipt pricing = new Receipt();
		for (Pizza pizza : order.getPizzas()) {
			double basePrice = pizza.getSize().getPrice();
			double toppingPrice = pizza.getToppings().stream().mapToDouble(t -> t.getPrice()).sum();
			double saucePrice = pizza.getSauces().stream().mapToDouble(s -> s.getPrice()).sum();
			double pizzaCost = basePrice + toppingPrice + saucePrice;
			pizza.setPrice(pizzaCost);
			pricing.addPizza(pizza);
		}
		if (order.getOrderType() == OrderType.DELIVERY) {
			pricing.setDelivery(DELIVERY_COST);
		}
		pricing.setTaxRate(TAX_RATE); 
		return pricing;
	}
	
}