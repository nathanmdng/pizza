package com.intuit.pizza.domain.pizza;

public enum Topping {

	CHEESE(0.2), ONION(0.3), MUSHROOM(0.4), 
	PEPPERONI(0.5), OLIVES(0.2), CHICKEN(0.6), 
	BEEF(0.6), HAM(0.4), PINEAPPLE(0.5);
	
	private double price;

	private Topping(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}
