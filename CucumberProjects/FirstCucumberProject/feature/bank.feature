  Feature: Cash Deposition Withdrawal
  
Scenario: Account Debit Credit Scenario Check
  Given The opening balance of my account is $90.00
    And I have deposited $100.25 in my account
  When I withdraw $10.55 from my account
  Then The balance should be $179.70
  
