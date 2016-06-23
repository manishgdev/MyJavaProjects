  Feature: Testing Cucumber Feature Files Execution from Maven
  
Scenario: Testing Feature File with Hooks
  Given This is simple method

@Hook1
Scenario: Testing Scenario with Single Hook
  Given This is simple method

@Hook2
Scenario: Testing Second Hook
  Given This is simple method
  
@Hook1,@Hook2
Scenario: Testing Feature File with Hooks
  Given This is simple method