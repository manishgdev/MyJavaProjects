  Feature: Testing Cucumber Feature Files Execution from Maven
  
Scenario: New teams should not have scored
  Given I register a new team "My Team"
  Then Team Name is "My Team"
  Then my score is 0
     
