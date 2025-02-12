package org.onboard.bdd.cashwithdrawal;

public class BankAccount {
    private int balance;
    private int lastDispensedAmount;


    public BankAccount(int balance) {
        this.balance = balance;
        this.lastDispensedAmount = 0;
    }


    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            lastDispensedAmount = amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }


    public int getBalance() {
        return balance;
    }


    public int getLastDispensedAmount() {
        return lastDispensedAmount;
    }
}
