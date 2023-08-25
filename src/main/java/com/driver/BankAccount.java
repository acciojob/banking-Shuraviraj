package com.driver;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

//    public BankAccount(String name, double balance, double minBalance) {
//
//    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public BankAccount() {
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits * 9 < sum) {
            throw new Exception("Account Number can not be generated");
        }
        List<Integer> accNum = new ArrayList<>();
        while (digits-- > 0) {
            if (sum >= 9) {
                sum -= 9;
                accNum.add(9);
            } else if (sum != 0) {
                accNum.add(sum);
                sum = 0;
            } else accNum.add(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : accNum) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        if (amount >= 0) this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) throw new Exception("Insufficient Balance");
        else if (amount >= 0) balance -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}