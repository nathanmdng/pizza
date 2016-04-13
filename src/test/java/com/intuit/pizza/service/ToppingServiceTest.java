package com.intuit.pizza.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.intuit.pizza.domain.pizza.Topping;

public class ToppingServiceTest {

	private ToppingService toppingService = new ToppingService();
	
	@Test
	public void testAddTopping() {
		toppingService.addTopping(new Topping("Bacon", 1.2));
		Topping bacon = toppingService.getTopping("Bacon");
		assertNotNull(bacon);
	}
	
	@Test
	public void testRemoveTopping() {
		Topping ham = toppingService.getTopping("Ham");
		assertNotNull(ham);
		toppingService.removeTopping("Ham");
		assertNull(toppingService.getTopping("Ham"));
	}
}
