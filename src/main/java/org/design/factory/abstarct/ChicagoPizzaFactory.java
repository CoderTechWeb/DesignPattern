package org.design.factory.abstarct;

import org.design.factory.Pizza;

public class ChicagoPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createCheesePizza() {
        return new ChicagoStyleCheesePizza();
    }
}
