package org.design.adpater;

public class PhonePe {

    private BankingService bankingService;

    public PhonePe(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    void crateBankAccount() {
        Bank bank = new Bank();
        bank.name = "Suresh";
        bank.pan = "AASSP10K";
        bank.aadhar = "678956689000";

        bankingService.addBankAccount(bank);
    }
}
