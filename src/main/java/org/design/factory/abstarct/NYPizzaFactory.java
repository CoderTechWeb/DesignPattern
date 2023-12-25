package org.design.factory.abstarct;

import org.design.factory.Pizza;

public class NYPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createCheesePizza() {
        return new NYStyleCheesePizza();
    }
}
