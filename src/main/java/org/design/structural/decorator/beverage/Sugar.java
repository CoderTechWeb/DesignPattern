package org.design.structural.decorator.beverage;

public class Sugar extends CondimentDecorator{

    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double cost() {
        return super.cost() + 0.3;
    }
}
