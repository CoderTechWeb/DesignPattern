package org.design.structural.decorator.beverage;

public class Milk extends CondimentDecorator{
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}
