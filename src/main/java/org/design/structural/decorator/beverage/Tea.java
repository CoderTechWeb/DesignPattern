package org.design.structural.decorator.beverage;

public class Tea implements  Beverage{
    @Override
    public String getDescription() {
        return "Tea";
    }
    @Override
    public double cost() {
        return 1.5;
    }
}
