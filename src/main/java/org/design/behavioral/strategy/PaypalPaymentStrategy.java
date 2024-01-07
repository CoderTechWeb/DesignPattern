package org.design.behavioral.strategy;

public class PaypalPaymentStrategy implements  PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of amount " + amount);
    }
}
