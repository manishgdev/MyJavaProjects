  Feature: Testing Cucumber Feature Files Execution from Maven
  
Scenario: Testing Scenario with No Hooks
  Given This is simple method "No Hook"

@Hook1
Scenario: Testing Scenario with Hook = Hook1
  Given This is simple method "Hook1  Only"

@Hook2
Scenario: Testing Scenario with Hook = Hook2
  Given This is simple method "Hook2 Only"
  
@Hook1,@Hook2
Scenario: Testing Scenario with two Hooks
  Given This is simple method "Hook1 & Hook2"