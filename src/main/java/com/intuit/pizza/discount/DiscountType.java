package com.intuit.pizza.discount;

public enum DiscountType {

	HALF_PRICE(new HalfPrice()), FREE_DELIVERY(new FreeDelivery());
	
	private Discount discount;

	private DiscountType(Discount discount) {
		this.discount = discount;
	}

	public Discount getDiscount() {
		return discount;
	}
	
}
