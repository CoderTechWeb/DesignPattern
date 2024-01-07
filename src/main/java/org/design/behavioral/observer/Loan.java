package org.design.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Loan implements  Subject{
    private final List<Observer> observers = new ArrayList<Observer>();
    private String type;
    private float interest;
    private String bank;

    public Loan(String type, float interest, String bank) {
        this.type = type;
        this.interest = interest;
        this.bank = bank;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer ob: observers) {
            System.out.println("Notifying Observers on change in Loan interest rate");
            ob.update(this.interest);
        }
    }
}
