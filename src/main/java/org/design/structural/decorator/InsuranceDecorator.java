package org.design.structural.decorator;

public class InsuranceDecorator extends CarRentalDecorator {
    public InsuranceDecorator(CarRental decoratedCarRental) {
        super(decoratedCarRental);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Insurance";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.0;
    }
}
