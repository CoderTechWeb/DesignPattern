package org.design.structural.decorator.beverage;

public class Coffee implements  Beverage{
    @Override
    public String getDescription() {
        return "Coffee";
    }
    @Override
    public double cost() {
        return 2.0;
    }
}
