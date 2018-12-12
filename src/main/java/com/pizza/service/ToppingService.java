package com.pizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizza.domain.pizza.Topping;

@Service
public class ToppingService {

	private List<Topping> toppings = new ArrayList<>();
	
	public ToppingService() {
		populateToppings();
	}

	private void populateToppings() {
		toppings.add(new Topping("Cheese", 0.2));
		toppings.add(new Topping("Ham", 0.4));
		toppings.add(new Topping("Pineapple", 0.5));
		toppings.add(new Topping("Chicken", 0.6));
	}
	
	public Topping getTopping(String name) {
		Optional<Topping> search = toppings.stream().filter(t -> t.getName().equals(name)).findFirst();
		if (search.isPresent()) {
			return search.get();
		}
		return null;
	}
	
	public void addTopping(Topping topping) {
		toppings.add(topping);
	}
	
	public void removeTopping(String name) {
		Topping topping = getTopping(name);
		toppings.remove(topping);
	}
}
