package org.design.structural.adpater;

public interface BankingService {

    void addBankAccount(Bank bank);

    boolean pay(double amount, String account);
    double checkBalance();
}
