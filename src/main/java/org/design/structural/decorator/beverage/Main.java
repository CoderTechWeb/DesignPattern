package org.design.structural.decorator.beverage;

public class Main {

    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());

        Beverage tea = new Tea();
        System.out.println(tea.getDescription() + " Cost: $" + tea.cost());

        Beverage milkCoffee = new Milk(new Sugar(new Coffee()));
        System.out.println(milkCoffee.getDescription() + " Cost: $" + milkCoffee.cost());

        Beverage milkTea = new Milk(new Tea());
        System.out.println(milkTea.getDescription() + " Cost: $" + milkTea.cost());
    }
}
