package org.design.creational.abstarct;

import org.design.creational.factory.Pizza;

public class ChicagoPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createCheesePizza() {
        return new ChicagoStyleCheesePizza();
    }
}
