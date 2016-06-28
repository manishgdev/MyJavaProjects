Feature: Test Different ways of Using Delimiters in Cucumber

Scenario: Testing the delimiter seperated by comma
Given the following animals: cow, horse, sheep

Scenario: Testing the delimiter seperated by #
Given the following animals seperated by Hash: Cow# Hen# Sheep# Fox

Scenario Outline: test the scenario outline with Delimiter and Transform
    Given I have these Numbers <values>
	Examples:
	| values         |
    | 5, 7, 9, 10, 1 | 
    | 1, 3, 5, 7, 11 |


Scenario Outline: test the scenario outline with Delimiter and Transform
    Given I have these Numbers in List <values>
	Examples:
	| values         |
    | 5, 7, 9, 10, 1 | 
    | 1, 3, 5, 7, 11 |
