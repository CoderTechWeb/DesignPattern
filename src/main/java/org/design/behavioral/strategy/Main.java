package org.design.behavioral.strategy;

public class Main {

    public static void main(String[] args) {
        PaymentProcessor debitPaymentProcessor = new PaymentProcessor(new DebitCardPaymentStrategy());
        debitPaymentProcessor.processPayment(100);

        PaymentProcessor creditPaymentProcessor = new PaymentProcessor(new CreditCardPaymentStrategy());
        creditPaymentProcessor.processPayment(1000);

        PaymentProcessor paypalPaymentProcessor = new PaymentProcessor(new PaypalPaymentStrategy());
        paypalPaymentProcessor.processPayment(500);
    }
}
