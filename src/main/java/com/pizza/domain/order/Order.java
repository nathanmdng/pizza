package com.pizza.domain.order;

import java.util.ArrayList;
import java.util.List;

import com.pizza.discount.DiscountType;
import com.pizza.domain.pizza.Pizza;

public class Order {

	private String name;
	private OrderType orderType;
	private List<Pizza> pizzas = new ArrayList<>();
	private String phoneNumber;
	private DiscountType discountType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizza) {
		this.pizzas = pizza;
	}
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	
}
