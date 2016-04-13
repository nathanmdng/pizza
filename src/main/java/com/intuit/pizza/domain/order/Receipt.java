package com.intuit.pizza.domain.order;

import java.util.ArrayList;
import java.util.List;

import com.intuit.pizza.domain.pizza.Pizza;

public class Receipt {

	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private double delivery;
	private double taxRate;
	private double discount;
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public double getDelivery() {
		return delivery;
	}
	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double tax) {
		this.taxRate = tax;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotal() {
		double pizzaCost = pizzas.stream().mapToDouble(p -> p.getPrice()).sum();
		return (pizzaCost + delivery) * (1 + taxRate) - discount;
	}
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	
}
