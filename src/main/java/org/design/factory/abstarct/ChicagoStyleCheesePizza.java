package org.design.factory.abstarct;

import org.design.factory.Pizza;

public class ChicagoStyleCheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Chicago Style Cheese Pizza");
    }

    public void bake() {
        System.out.println("Baking Chicago Style Cheese Pizza");
    }

    public void cut() {
        System.out.println("Cutting Chicago Style Cheese Pizza");
    }

    public void box() {
        System.out.println("Boxing Chicago Style Cheese Pizza");
    }
}
