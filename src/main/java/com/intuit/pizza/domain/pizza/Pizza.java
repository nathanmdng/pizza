package com.intuit.pizza.domain.pizza;

import java.util.HashSet;
import java.util.Set;

public class Pizza {

	private String name;
	private Base base;
	private Size size;
	private Set<Sauce> sauces = new HashSet<>();
	private Set<Topping> toppings = new HashSet<>();
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public Set<Sauce> getSauces() {
		return sauces;
	}
	public Set<Topping> getToppings() {
		return toppings;
	}
	public void addTopping(Topping topping) {
		toppings.add(topping);
	}
	public void removeTopping(Topping topping) {
		toppings.remove(topping);
	}
	public void addSauce(Sauce sauce) {
		sauces.add(sauce);
	}
	public void removeSauce(Sauce sauce) {
		sauces.remove(sauce);
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
