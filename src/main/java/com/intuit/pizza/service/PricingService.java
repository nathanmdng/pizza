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
			fullCost += getDeliveryCost();
		}
		double priceWithTax = applyTax(fullCost);
		return priceWithTax;
	}
	
	private double applyTax(double price) {
		return price * TAX_RATE;
	}
	
	public double getDeliveryCost() {
		return DELIVERY_COST;
	}
}
