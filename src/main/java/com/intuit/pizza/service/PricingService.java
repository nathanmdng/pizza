package com.intuit.pizza.service;

import org.springframework.stereotype.Service;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.domain.order.OrderType;
import com.intuit.pizza.domain.pizza.Pizza;

@Service
public class PricingService {

	private static final double TAX_RATE = 1.12;
	private static final double DELIVERY_COST = 5;
	
	public double calculatePrice(Order order) {
		double fullCost = 0;
		for (Pizza pizza : order.getPizzas()) {
			double basePrice = pizza.getSize().getPrice();
			double toppingPrice = pizza.getToppings().stream().mapToDouble(t -> t.getPrice()).sum();
			double saucePrice = pizza.getSauces().stream().mapToDouble(s -> s.getPrice()).sum();
			fullCost += basePrice + toppingPrice + saucePrice;
		}
		if (order.getOrderType() == OrderType.DELIVERY) {
			applyDelivery(fullCost);
		}
		return applyTax(fullCost);
	}
	
	private double applyTax(double price) {
		return price * TAX_RATE;
	}
	
	private double applyDelivery(double price) {
		return price + DELIVERY_COST;
	}
	
}
