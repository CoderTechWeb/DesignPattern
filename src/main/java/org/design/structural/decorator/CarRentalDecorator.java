package org.design.structural.decorator;

public abstract class CarRentalDecorator implements CarRental{
    protected CarRental decoratedCarRental;

    public CarRentalDecorator(CarRental decoratedCarRental) {
        this.decoratedCarRental = decoratedCarRental;
    }

    @Override
    public String getDescription() {
        return decoratedCarRental.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCarRental.getCost();
    }
}
