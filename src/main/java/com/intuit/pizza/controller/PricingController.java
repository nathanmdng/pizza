package com.intuit.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intuit.pizza.discount.Discount;
import com.intuit.pizza.domain.order.Order;
import com.intuit.pizza.service.PricingService;

@Controller
public class PricingController {

	@Autowired private PricingService pricingService;
	
	@RequestMapping(value = "pricing", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Double> getPricing(@RequestBody Order order) {
		Discount discount = order.getDiscountType().getDiscount();
		double netPrice = discount.apply(pricingService, order);
		return new ResponseEntity<Double>(netPrice, HttpStatus.OK);
	}
}
