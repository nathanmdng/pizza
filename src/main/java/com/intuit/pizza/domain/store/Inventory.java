package com.intuit.pizza.domain.store;

import java.util.ArrayList;
import java.util.List;

import com.intuit.pizza.domain.pizza.Pizza;


public class Inventory {

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
	
	public void removePizza(Pizza pizza) {
		pizzas.remove(pizza);
	}
}
