/**
 *
 * Implement the step definition class, methods and application classes/interfaces for the below feature.
 * Feature: Widraw cash from account
 *   In order to pay for my daily expenses
 *   As an accounter holder
 *   I want to withdraw cash
 *
 *   Scenario: Withdraw cash from account in credit
 *     Given I have a balance of $100 in my account
 *     When I request $20
 *     Then $20 should be dispensed
 */

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
