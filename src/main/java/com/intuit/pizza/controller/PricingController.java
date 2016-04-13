package com.intuit.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.service.PricingService;

@Controller
public class PricingController {

	@Autowired private PricingService pricingService;
	
	@RequestMapping(value = "pricing", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Double> priceOrder(@RequestBody Order order) {
		double totalPrice = pricingService.calculatePrice(order);
		return new ResponseEntity<Double>(totalPrice, HttpStatus.OK);
	}

}
