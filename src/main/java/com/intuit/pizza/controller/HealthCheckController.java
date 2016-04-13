package com.intuit.pizza.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

	@RequestMapping(value = "healthCheck", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, String> getHealthCheck() {
		Map<String, String> status = new HashMap<>();
		status.put("status", "OK");
		return status;
	}

}
