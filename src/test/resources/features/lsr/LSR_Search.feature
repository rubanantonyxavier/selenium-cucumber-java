@ui
@lsr
@search
Feature: LSR - Search

  Scenario: Verify LSR - Search is successful
    Given open LSR URL
    Then verify LSR Login page is displayed
    When login in LSR Application
    Then verify LSR Search page is displayed
    When the TEXT BOX is filled with values in LSR Search page
      | Field Name    | Field Value |
      | Borrower SSN1 | 111         |
      | Borrower SSN2 | 23          |
      | Borrower SSN3 | 4444        |
    And click on Submit button in LSR Search page
    Then verify LSR Search Result page is displayed
    When click on SignOut in LSR
    Then logout page is displayed in LSR
