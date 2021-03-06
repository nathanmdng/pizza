package com.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.domain.order.Order;
import com.pizza.domain.order.Receipt;
import com.pizza.service.PricingService;

@Controller
public class PricingController {

	@Autowired private PricingService pricingService;
	
	@RequestMapping(value = "pricing", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Receipt> getPricing(@RequestBody Order order) {
		Receipt pricing = pricingService.calculatePrice(order);
		return new ResponseEntity<Receipt>(pricing, HttpStatus.OK);
	}
}
