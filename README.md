# Pizza Delivery System

## Usage:

**add a topping**
/store/topping POST
{"name": "Peppers", "price": 0.4}

**remove a topping**
/store/topping/Peppers DELETE

**add a pizza**
/store/pizza POST
{"id": 1, "base": "PAN", "size": "LARGE", "toppings": ["topping" {"name": "Cheese", "price": 0.4}]}

**get order pricing**
/pricing POST
{ order details... }

## Patterns
* Using strategy to apply discounts
* Using Spring which embodies pattens such as singleton, MVC, front controller
