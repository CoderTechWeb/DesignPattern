package org.design.structural.decorator;

public class GPSDecorator extends CarRentalDecorator{

    public GPSDecorator(CarRental decoratedCarRental) {
        super(decoratedCarRental);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", GPS";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }
}
