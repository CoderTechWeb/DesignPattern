package org.design.behavioral.strategy;

public class DebitCardPaymentStrategy implements  PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit debit payment of amount " + amount);
    }
}
