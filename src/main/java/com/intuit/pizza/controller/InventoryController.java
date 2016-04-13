package com.intuit.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intuit.pizza.domain.pizza.Topping;
import com.intuit.pizza.service.ToppingService;

@Controller
public class InventoryController {

	@Autowired private ToppingService toppingManager;
	
	@RequestMapping(value = "topping", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Void> addTopping(@RequestBody Topping topping) {
		toppingManager.addTopping(topping);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "topping/name/{toppingName}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<Void> removeTopping(@PathVariable String toppingName) {
		toppingManager.removeTopping(toppingName);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
