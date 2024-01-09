package org.design.creational.abstarct;

import org.design.creational.factory.Pizza;

public class NYStyleCheesePizza implements Pizza {

    public void prepare() {
        System.out.println("Preparing New York Style Cheese Pizza");
    }

    public void bake() {
        System.out.println("Baking New York Style Cheese Pizza");
    }

    public void cut() {
        System.out.println("Cutting New York Style Cheese Pizza");
    }

    public void box() {
        System.out.println("Boxing New York Style Cheese Pizza");
    }
}
