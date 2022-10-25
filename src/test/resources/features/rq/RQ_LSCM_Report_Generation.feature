@ui
@rq
@lscm
Feature: RQ - LSCM Report Generation And Validation

  @contract
  Scenario: Verify RQ - LSCM Report Generation using Contract User
    Given open RQ URL
    When login in RQ Application with Contract User
    Then verify RQ Subject Search page is displayed
    When click on Property tab in RQ Subject Search page
    And enter Address '714 LATCH STREET, New Viscosis, US 6584' in Property Tab of RQ Subject Search page
    And click on Submit Request button in RQ Subject Search page
    Then verify RQ Property Report page is displayed
    When enable Loan Safe Suite in RQ Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in RQ Property Report page
    And click on VIEW ALL REPORTS button in RQ Property Report page
    Then verify Report Summary Window is displayed in RQ Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of RQ Property Report page
    And switch to New window
    Then verify RQ LSCM Input page is displayed
    And verify the TEXT BOX is displayed with values in RQ LSCM Input page
      | Field Name     | Field Value      |
      | Street Address | 714 LATCH STREET |
      | City           | New Viscosis     |
      | State          | US               |
      | Zip            | 6584             |
    When the TEXT BOX is filled with values in RQ LSCM Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in RQ LSCM Input page
    Then verify RQ LSCM Report page is displayed for Contract User
    And verify LSCM Report is displayed in RQ LSCM Report page
    And verify the Section is displayed in RQ LSCM Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Appraisal Review Alerts                |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in RQ LSCM Report page
      | Field Name                    | Field Value                                 |
      | USV - Report Order No.        | [NOT EMPTY]                                 |
      | USV - Street Address          | 714 LATCH STREET                            |
      | USV - City, State, Zip        | New Viscosis, US 6584                       |
      | RI - Report Order No.         | [NOT EMPTY]                                 |
      | RI - Report Date              | [DATETIME --> MMM d, yyyy h:mm a]           |
      | LI - Loan Number              | [VERIFY --> LOAN NUMBER]                    |
      | LI - Reported Appraised Value | $60,000                                     |
      | FA - Collateral Risk Score    | [MATCH --> COLLATERAL RISK SCORE: \\d{1,3}] |

  @order
  @qa_only
  Scenario: Verify RQ - LSCM Report Generation using Order User
    Given open RQ URL
    When login in RQ Application with Order User
    Then verify RQ Subject Search page is displayed
    When click on Property tab in RQ Subject Search page
    And enter Address '714 WHITLATCH DR, LANCASTER, CA 93535' in Property Tab of RQ Subject Search page
    And click on Submit Request button in RQ Subject Search page
    Then verify RQ Property Report page is displayed
    When enable Loan Safe Suite in RQ Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in RQ Property Report page
    And click on VIEW ALL REPORTS button in RQ Property Report page
    Then verify Report Summary Window is displayed in RQ Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of RQ Property Report page
    And switch to New window
    Then verify RQ LSCM Input page is displayed
    And verify the TEXT BOX is displayed with values in RQ LSCM Input page
      | Field Name     | Field Value      |
      | Street Address | 714 WHITLATCH DR |
      | City           | LANCASTER        |
      | State          | CA               |
      | Zip            | 93535            |
    When the TEXT BOX is filled with values in RQ LSCM Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in RQ LSCM Input page
    Then verify RQ LSCM Report page is displayed for Order User
    And verify LSCM Report is displayed in RQ LSCM Report page
    And verify the Section is displayed in RQ LSCM Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Appraisal Review Alerts                |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in RQ LSCM Report page
      | Field Name                         | Field Value                                 |
      | RI - Report Order No.              | [NOT EMPTY]                                 |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mm a]           |
      | RI - Standardized Property Address | 714 Whitlatch Dr\nLancaster, Ca 93535       |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]                    |
      | LI - Reported Appraised Value      | $60,000                                     |
      | FA - Collateral Risk Score         | [MATCH --> COLLATERAL RISK SCORE: \\d{1,3}] |

  @order
  @uat_only
  Scenario: Verify RQ - LSCM Report Generation using Order User
    Given open RQ URL
    When login in RQ Application with Order User
    Then verify RQ Subject Search page is displayed
    When click on Property tab in RQ Subject Search page
    And enter Address '714 WHITLATCH DR, LANCASTER, CA 93535' in Property Tab of RQ Subject Search page
    And click on Submit Request button in RQ Subject Search page
    Then verify RQ Property Report page is displayed
    When enable Loan Safe Suite in RQ Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in RQ Property Report page
    And click on VIEW ALL REPORTS button in RQ Property Report page
    Then verify Report Summary Window is displayed in RQ Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of RQ Property Report page
    And switch to New window
    Then verify RQ LSCM Input page is displayed
    And verify the TEXT BOX is displayed with values in RQ LSCM Input page
      | Field Name     | Field Value      |
      | Street Address | 714 WHITLATCH DR |
      | City           | LANCASTER        |
      | State          | CA               |
      | Zip            | 93535            |
    When the TEXT BOX is filled with values in RQ LSCM Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in RQ LSCM Input page
    Then verify RQ LSCM Report page is displayed for Order User
    And verify LSCM Report is displayed in RQ LSCM Report page
    And verify the Section is displayed in RQ LSCM Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in RQ LSCM Report page
      | Field Name                         | Field Value                           |
      | RI - Report Order No.              | [NOT EMPTY]                           |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mm a]     |
      | RI - Standardized Property Address | 714 Whitlatch Dr\nLancaster, Ca 93535 |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]              |
      | LI - Reported Appraised Value      | $60,000                               |
