package org.design.creational.abstarct;

import org.design.creational.factory.Pizza;

public class Main {

    public static void main(String[] args) {
        System.out.println("---------------- nyPizzaFactory ----------------");
        NYPizzaFactory nyPizzaFactory = new NYPizzaFactory();
        Pizza nyCheesePizza  = nyPizzaFactory.createCheesePizza();
        nyCheesePizza.prepare();
        nyCheesePizza.bake();
        nyCheesePizza.cut();
        nyCheesePizza.box();

        System.out.println();
        // Order and prepare Chicago style cheese pizza
        System.out.println("---------------- chicagoCheesePizza ----------------");
        ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
        Pizza chicagoCheesePizza = chicagoPizzaFactory.createCheesePizza();
        chicagoCheesePizza.prepare();
        chicagoCheesePizza.bake();
        chicagoCheesePizza.cut();
        chicagoCheesePizza.box();
    }
}
