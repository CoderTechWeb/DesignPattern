package org.design.structural.facade.hometheater;

public class HomeTheaterFacade {
    private final Television tv;
    private final SoundSystem soundSystem;

    public HomeTheaterFacade() {
        this.tv = new Television();
        this.soundSystem = new SoundSystem();
    }

    public void watchMovie(String movie) {
        tv.turnOn();
        tv.changeChannel(3); // Assume channel 3 is for movies
        soundSystem.turnOn();
        soundSystem.adjustVolume(20); // Set volume for the movie
        System.out.println("Now watching " + movie);
    }

    public void turnOff() {
        tv.turnOff();
        soundSystem.turnOff();
        System.out.println("Home theater system turned off");
    }
}
