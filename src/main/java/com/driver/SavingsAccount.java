package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount() {
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount >= 0) {
            if (amount > maxWithdrawalLimit) throw new Exception("Maximum Withdraw Limit Exceed");
            if (amount > getBalance()) throw new Exception("Insufficient Balance");
            setBalance(getBalance() - amount);
        }
    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount
        double si = (getBalance() * rate * years) / 100;
        return si;
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double ci = getBalance();
        for (int i = 0; i < years; i++) {
            for (int j = 0; j < times; j++) {
                ci = ci * (1 + rate / times);
            }
        }
        return ci;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}
