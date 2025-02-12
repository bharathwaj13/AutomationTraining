package org.onboard.bdd.cashwithdrawal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WithdrawalSteps {

    BankAccount account;


    @Given("I have a balance of ${int} in my account")
    public void givenIHaveABalanceOf100InMyAccount(Integer balance) {
        account = new BankAccount(balance);
    }

    @When("I request ${int}")
    public void whenIRequest20(Integer withdrawAmount) {
        account.withdraw(withdrawAmount);
    }

    @Then("${int} should be dispensed")
    public void then20ShouldBeDispensed(Integer dispenseAmount) {
        assertEquals(account.getLastDispensedAmount(), (int) dispenseAmount);
    }


    @Then("my account balance will be ${int}")
    public void thenMyAccountBalanceWillBe80(Integer balance) {
        assertEquals(account.getBalance(), (int) balance);
    }
}
