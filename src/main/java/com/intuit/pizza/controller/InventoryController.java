package com.intuit.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intuit.pizza.domain.pizza.Pizza;
import com.intuit.pizza.domain.pizza.Topping;
import com.intuit.pizza.service.InventoryService;
import com.intuit.pizza.service.ToppingService;

@Controller
@RequestMapping(value = "inventory")
public class InventoryController {

	@Autowired private ToppingService toppingService;
	@Autowired private InventoryService inventoryService;
	
	@RequestMapping(value = "topping", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Void> addTopping(@RequestBody Topping topping) {
		toppingService.addTopping(topping);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "topping/name/{toppingName}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<Void> removeTopping(@PathVariable String toppingName) {
		toppingService.removeTopping(toppingName);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "pizza", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<Void> addPizza(@RequestBody Pizza pizza) {
		inventoryService.addPizza(pizza);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "pizza", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<List<Pizza>> getRemainingPizzas() {
		return new ResponseEntity<List<Pizza>>(inventoryService.getPizzas(), HttpStatus.OK);
	}

}
