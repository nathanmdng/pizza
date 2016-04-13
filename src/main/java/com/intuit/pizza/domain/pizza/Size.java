package com.intuit.pizza.domain.pizza;

public enum Size {

	SMALL(6), MEDIUM(8), LARGE(10);
	
	private double price;

	private Size(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
}
