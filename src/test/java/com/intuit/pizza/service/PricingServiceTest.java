package com.intuit.pizza.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.domain.order.OrderType;
import com.intuit.pizza.domain.pizza.Base;
import com.intuit.pizza.domain.pizza.Pizza;
import com.intuit.pizza.domain.pizza.Sauce;
import com.intuit.pizza.domain.pizza.Size;
import com.intuit.pizza.domain.pizza.Topping;

public class PricingServiceTest {

	private PricingService service = new PricingService();
	
	@Test
	public void testPricing() {
		Order order = new Order();
		order.setOrderType(OrderType.DELIVERY);
		order.addPizza(getCheesePizza());
		order.addPizza(getHawaiianPizza());
		double price = service.calculatePrice(order);
		assertEquals(22.736, price, 0.0001);
	}
	
	public Pizza getCheesePizza() {
		Pizza pizza = new Pizza();
		pizza.addSauce(Sauce.TOMATO);
		pizza.addTopping(Topping.CHEESE);
		pizza.setBase(Base.CLASSIC);
		pizza.setSize(Size.MEDIUM);
		return pizza;
	}
	
	public Pizza getHawaiianPizza() {
		Pizza pizza = new Pizza(); 
		pizza.addSauce(Sauce.TOMATO);
		pizza.addTopping(Topping.CHEESE);
		pizza.addTopping(Topping.HAM);
		pizza.addTopping(Topping.PINEAPPLE);
		pizza.setBase(Base.PAN);
		pizza.setSize(Size.LARGE);
		return pizza;
	}
}
