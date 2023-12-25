package org.design.factory;

public class Main {

    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();

        // Order a cheese pizza
        System.out.println("---------------- Cheese Pizza ----------------");
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        cheesePizza.prepare();
        cheesePizza.bake();
        cheesePizza.cut();
        cheesePizza.box();

        // Order a pepperoni pizza
        System.out.println("---------------- Pepperoni Pizza ----------------");
        Pizza pepperoniPizza = pizzaFactory.createPizza("pepperoni");
        pepperoniPizza.prepare();
        pepperoniPizza.bake();
        pepperoniPizza.cut();
        pepperoniPizza.box();    }
}
