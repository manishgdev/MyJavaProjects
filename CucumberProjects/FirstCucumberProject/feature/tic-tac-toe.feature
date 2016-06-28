  Feature: This is to test the Game of Tic-Tac-Toe and Datatable in the Cucumber
  
  Scenario: When user goes to correct position
  Given a board like this :
     |   | 1 | 2 | 3 |
     | 1 |   |   |   |
     | 2 |   |   |   |
     | 3 |   |   |   |
  When player x plays in row 2, column 1
  Then the board should look like this:
     |   | 1 | 2 | 3 |
     | 1 |   |   |   |
     | 2 | x |   |   |
     | 3 |   |   |   |

  Scenario: When user goes to wrong position
  Given a board like this :
     |   | 1 | 2 | 3 |
     | 1 |   |   |   |
     | 2 |   |   |   |
     | 3 |   |   |   |
  When player x plays in row 2, column 3
  Then the board should look like this:
     |   | 1 | 2 | 3 |
     | 1 |   |   |   |
     | 2 | x |   |   |
     | 3 |   |   |   |
