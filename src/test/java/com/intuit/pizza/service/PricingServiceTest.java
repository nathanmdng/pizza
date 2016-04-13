package com.intuit.pizza.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;
import com.intuit.pizza.discount.DiscountType;
import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.domain.order.OrderType;
import com.intuit.pizza.domain.order.Receipt;
import com.intuit.pizza.domain.pizza.Base;
import com.intuit.pizza.domain.pizza.Pizza;
import com.intuit.pizza.domain.pizza.Sauce;
import com.intuit.pizza.domain.pizza.Size;

public class PricingServiceTest {

	private PricingService pricingService = new PricingService();
	private ToppingService toppingService = new ToppingService();
	private Gson gson = new Gson();
	
	@Test
	public void testPricing() {
		Order order = createOrder();
		Receipt price = pricingService.calculatePrice(order);
		assertEquals(5, price.getDelivery(), 0.0001);
		assertEquals(28.336, price.getTotal(), 0.0001);
		String jsonValue = gson.toJson(order);
		System.out.println(jsonValue);
	}

	@Test
	public void testPricingWithDiscount() {
		Order order = createOrder();
		order.setDiscountType(DiscountType.HALF_PRICE);
		Receipt price = pricingService.calculatePrice(order);
		assertEquals(5, price.getDelivery(), 0.0001);
		assertEquals(14.168, price.getTotal(), 0.0001);
		assertEquals(14.168, price.getDiscount(), 0.0001);
		String jsonValue = gson.toJson(order);
		System.out.println(jsonValue);
	}

	private Order createOrder() {
		Order order = new Order();
		order.setOrderType(OrderType.DELIVERY);
		order.addPizza(getCheesePizza());
		order.addPizza(getHawaiianPizza());
		return order;
	}
	
	private Pizza getCheesePizza() {
		Pizza pizza = new Pizza();
		pizza.addSauce(Sauce.TOMATO);
		pizza.addTopping(toppingService.getTopping("Cheese"));
		pizza.setBase(Base.CLASSIC);
		pizza.setSize(Size.MEDIUM);
		return pizza;
	}
	
	private Pizza getHawaiianPizza() {
		Pizza pizza = new Pizza(); 
		pizza.addSauce(Sauce.TOMATO);
		pizza.addTopping(toppingService.getTopping("Cheese"));
		pizza.addTopping(toppingService.getTopping("Ham"));
		pizza.addTopping(toppingService.getTopping("Pineapple"));
		pizza.setBase(Base.PAN);
		pizza.setSize(Size.LARGE);
		return pizza;
	}
}
