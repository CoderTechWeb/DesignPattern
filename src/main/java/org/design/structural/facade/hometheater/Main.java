package org.design.structural.facade.hometheater;

public class Main {

    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie("Inception");
        homeTheater.turnOff();
    }
}
