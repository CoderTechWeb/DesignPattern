package org.design.creational.factory;

public class PizzaFactory {

	public Pizza createPizza(String pizzaType) {
		if ("cheese".equals(pizzaType)) {
			return new CheesePizza();
		} else if ("pepperoni".equals(pizzaType)) {
			return new PepperoniPizza();
		} else {
			throw new IllegalArgumentException("Invalid pizza type");
		}
	}
}
