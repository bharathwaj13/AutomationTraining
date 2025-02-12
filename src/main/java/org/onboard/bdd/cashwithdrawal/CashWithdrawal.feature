Feature: Cash Withdrawal
  As an account holder
  I want to withdraw money from my account
  So that I can pay for daily expenses

  Scenario: Withdraw cash from account in credit
    Given I have a balance of $100 in my account
    When I request $20
    Then $20 should be dispensed
    And my account balance will be $80