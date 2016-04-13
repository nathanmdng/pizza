package com.intuit.pizza.discount;

import com.intuit.pizza.domain.order.Receipt;

public interface Discount {

	Receipt apply(Receipt pricing);
	
}
