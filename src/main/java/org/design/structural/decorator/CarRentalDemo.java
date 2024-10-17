package org.design.structural.decorator;

public class CarRentalDemo {

    public static void main(String[] args) {
        CarRental basicCarRental = new BasicCarRental();

        // Add GPS and Insurance to the basic car rental
        CarRental rentalWithGPSAndInsurance = new InsuranceDecorator(new GPSDecorator(basicCarRental));

        System.out.println("Description: " + rentalWithGPSAndInsurance.getDescription());
        System.out.println("Cost: $" + rentalWithGPSAndInsurance.getCost());

        // Add GPS, Insurance, and Sunroof
        CarRental fullFeatureRental = new SunroofDecorator(new InsuranceDecorator(new GPSDecorator(basicCarRental)));

        System.out.println("Description: " + fullFeatureRental.getDescription());
        System.out.println("Cost: $" + fullFeatureRental.getCost());
    }
}
