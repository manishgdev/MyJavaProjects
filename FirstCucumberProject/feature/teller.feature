Feature: Amount from the Teller Machine

Scenario: Successful withdrawal from an account in credit
Given There is $100.00 in my account
When I withdraw $20 from the Teller Machine
Then $20 should be dispensed from Teller Machine
And Amount left in the bank should be $80.0
