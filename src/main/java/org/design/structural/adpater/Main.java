package org.design.structural.adpater;

public class Main {

    public static void main(String[] args) {
        YesBankAdapter yesBankAdapter = new YesBankAdapter(new YesBankAPI());

        PhonePe phonePe = new PhonePe(yesBankAdapter);

        phonePe.crateBankAccount();
    }
}
