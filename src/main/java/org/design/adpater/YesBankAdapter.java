package org.design.adpater;

public class YesBankAdapter implements  BankingService{

    private final YesBankAPI yesBankAPI;

    public YesBankAdapter(YesBankAPI yesBankAPI) {
        this.yesBankAPI = yesBankAPI;
    }

    @Override
    public void addBankAccount(Bank bank) {
        System.out.println("Calling yes bank api for registering bank account");
        yesBankAPI.registerBankAccount(bank.type, bank.name, bank.pan, bank.dob);
    }

    @Override
    public boolean pay(double amount, String account) {
        return false;
    }

    @Override
    public double checkBalance() {
        return 0;
    }
}
