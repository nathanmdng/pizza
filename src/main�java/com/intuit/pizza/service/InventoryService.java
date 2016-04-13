package com.intuit.pizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intuit.pizza.domain.pizza.Pizza;

@Service
public class InventoryService {

	private List<Pizza> pizzas = new ArrayList<>();

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	public Pizza getById(long id) {
		Optional<Pizza> search = pizzas.stream().filter(p -> p.getId() == id).findFirst();
		if (search.isPresent()) {
			return search.get();
		}
		return null;
	}
	
	public void removePizza(long id) {
		pizzas.remove(getById(id));
	}
}