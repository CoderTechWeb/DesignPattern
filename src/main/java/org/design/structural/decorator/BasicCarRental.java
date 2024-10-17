package org.design.structural.decorator;

public class BasicCarRental implements CarRental {
    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Basic Car Rental";
    }
}
