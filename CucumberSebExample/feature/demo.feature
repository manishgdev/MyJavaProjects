Feature: Team Scoring
team starts with zero score
Correct answers gets points based on difficulty of the question
  
Background:
Given I register a new team "My Team"
 
@Score
Scenario Outline: New teams should not have scored
Given I register a new team "My Team"
Then Team Name is "My Team"
Then my score is <score>
Examples:
| score |
| 0 |
| 2 |
  
@Map
Scenario: Team Score Maps
Given the leader board looks like:
| Pirates | 20 |
| Sailors | 25 |
