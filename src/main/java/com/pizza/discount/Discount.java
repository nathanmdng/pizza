package com.pizza.discount;

import com.pizza.domain.order.Receipt;

public interface Discount {

	Receipt apply(Receipt pricing);
	
}
