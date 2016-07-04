Feature: Test Different ways of Using Delimiters in Cucumber

Scenario: Inactive with no number between word and anotherword
Given inactive update message is received for word anotherword 1

Scenario: Inactive with number between word and anotherword
Given active update message is received for word 1 anotherword 7

Scenario: Aactive with number between word and anotherword
Given inactive update message is received for word 7 anotherword 3
