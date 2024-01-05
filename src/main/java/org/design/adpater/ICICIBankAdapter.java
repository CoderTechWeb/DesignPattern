package org.design.adpater;

public class ICICIBankAdapter implements  BankingService{

    private final ICICIBankAPI iciciBankAPI;

    public ICICIBankAdapter(ICICIBankAPI iciciBankAPI) {
        this.iciciBankAPI = iciciBankAPI;
    }

    @Override
    public void addBankAccount(Bank bank) {
        System.out.println("Calling ICICI bank api for registering bank account");
        iciciBankAPI.addBankAccount(bank.name, bank.aadhar, bank.pan);
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
