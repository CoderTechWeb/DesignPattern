package org.design.structural.decorator;

public class SunroofDecorator extends CarRentalDecorator {
    public SunroofDecorator(CarRental decoratedCarRental) {
        super(decoratedCarRental);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sunroof";
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }
}
