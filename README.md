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
{"orderType":"DELIVERY","pizzas":[{"id":1,"base":"CLASSIC","size":"MEDIUM","sauces":["TOMATO"],"toppings":[{"name":"Cheese","price":0.2}],"price":0.0},{"id":2,"base":"PAN","size":"LARGE","sauces":["TOMATO"],"toppings":[{"name":"Ham","price":0.4},{"name":"Pineapple","price":0.5},{"name":"Cheese","price":0.2}],"price":0.0}], "discountType": "HALF_PRICE"}

Response
{"pizzas":[{"id":1,"base":"CLASSIC","size":"MEDIUM","sauces":["TOMATO"],"toppings":[{"name":"Cheese","price":0.2}],"price":8.7},{"id":2,"base":"PAN","size":"LARGE","sauces":["TOMATO"],"toppings":[{"name":"Ham","price":0.4},{"name":"Pineapple","price":0.5},{"name":"Cheese","price":0.2}],"price":11.6}],"delivery":5.0,"taxRate":0.12,"discount":14.168,"total":14.168}

## Patterns
* Using strategy to apply discounts
* Using Spring which embodies pattens such as singleton, MVC, front controller
