package com.intuit.pizza.domain.pizza;

import java.util.HashSet;
import java.util.Set;

public class Pizza {

	private long id;
	private Base base;
	private Size size;
	private Set<Sauce> sauces = new HashSet<>();
	private Set<Topping> toppings = new HashSet<>();
	private double price;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
