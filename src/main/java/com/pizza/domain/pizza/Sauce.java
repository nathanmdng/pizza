package com.pizza.domain.pizza;

public enum Sauce {

	TOMATO(0.5), BBQ(0.6), PESTO(0.7);
	
	private double price;

	private Sauce(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	
}
