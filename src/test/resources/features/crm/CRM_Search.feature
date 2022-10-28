@ui
@crm
@search
Feature: CRM - Search

  Scenario: Verify CRM - Search is successful
    Given open CRM URL
    Then verify CRM Login page is displayed
    When login in CRM Application
    Then verify CRM Search page is displayed
    When the TEXT BOX is filled with values in CRM Search page
      | Field Name    | Field Value |
      | Borrower SSN1 | 111         |
      | Borrower SSN2 | 23          |
      | Borrower SSN3 | 4444        |
    And click on Submit button in CRM Search page
    Then verify CRM Search Result page is displayed
    When click on SignOut in CRM
    Then logout page is displayed in CRM
