package com.intuit.pizza.service;

import java.util.ArrayList;
import java.util.List;

import com.intuit.pizza.domain.pizza.Pizza;
import com.intuit.pizza.exception.NoPizzasAvailableException;


public class InventoryService {

	private List<Pizza> pizzas = new ArrayList<>();

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	
	public void removePizza(Pizza pizza) throws NoPizzasAvailableException {
		if (pizzas.isEmpty()) {
			throw new NoPizzasAvailableException();
		}
		pizzas.remove(pizza);
	}
	
}