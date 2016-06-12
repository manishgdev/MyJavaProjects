  Feature: Team Scoring
  team starts with zero score
  Correct answers gets points based on difficulty of the question
  
Scenario: New teams should not have scored
  Given I register a new team "My Team"
  Then my score is 0
  Then Team Name is "My Team"