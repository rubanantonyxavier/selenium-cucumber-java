@ui
@ni
@pxi
Feature: NI - PXI Report Generation And Validation

  @contract
  Scenario: Verify NI - PXI Report Generation using Contract User
    Given open NI URL
    When login in NI Application with Contract User
    Then verify NI Subject Search page is displayed
    When click on Property tab in NI Subject Search page
    And enter Address '714 LATCH STREET, New Viscosis, US 6584' in Property Tab of NI Subject Search page
    And click on Submit Request button in NI Subject Search page
    Then verify NI Property Report page is displayed
    When enable Loan Safe Suite in NI Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in NI Property Report page
    And click on VIEW ALL REPORTS button in NI Property Report page
    Then verify Report Summary Window is displayed in NI Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of NI Property Report page
    And switch to New window
    Then verify NI PXI Input page is displayed
    And verify the TEXT BOX is displayed with values in NI PXI Input page
      | Field Name     | Field Value      |
      | Street Address | 714 LATCH STREET |
      | City           | New Viscosis     |
      | State          | US               |
      | Zip            | 6584             |
    When the TEXT BOX is filled with values in NI PXI Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in NI PXI Input page
    Then verify NI PXI Report page is displayed for Contract User
    And verify PXI Report is displayed in NI PXI Report page
    And verify the Section is displayed in NI PXI Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Appraisal Review Alerts                |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in NI PXI Report page
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
  Scenario: Verify NI - PXI Report Generation using Order User
    Given open NI URL
    When login in NI Application with Order User
    Then verify NI Subject Search page is displayed
    When click on Property tab in NI Subject Search page
    And enter Address '714 WHITLATCH DR, LANCASTER, CA 93535' in Property Tab of NI Subject Search page
    And click on Submit Request button in NI Subject Search page
    Then verify NI Property Report page is displayed
    When enable Loan Safe Suite in NI Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in NI Property Report page
    And click on VIEW ALL REPORTS button in NI Property Report page
    Then verify Report Summary Window is displayed in NI Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of NI Property Report page
    And switch to New window
    Then verify NI PXI Input page is displayed
    And verify the TEXT BOX is displayed with values in NI PXI Input page
      | Field Name     | Field Value      |
      | Street Address | 714 WHITLATCH DR |
      | City           | LANCASTER        |
      | State          | CA               |
      | Zip            | 93535            |
    When the TEXT BOX is filled with values in NI PXI Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in NI PXI Input page
    Then verify NI PXI Report page is displayed for Order User
    And verify PXI Report is displayed in NI PXI Report page
    And verify the Section is displayed in NI PXI Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Appraisal Review Alerts                |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in NI PXI Report page
      | Field Name                         | Field Value                                 |
      | RI - Report Order No.              | [NOT EMPTY]                                 |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mm a]           |
      | RI - Standardized Property Address | 714 Whitlatch Dr\nLancaster, Ca 93535       |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]                    |
      | LI - Reported Appraised Value      | $60,000                                     |
      | FA - Collateral Risk Score         | [MATCH --> COLLATERAL RISK SCORE: \\d{1,3}] |

  @order
  @uat_only
  Scenario: Verify NI - PXI Report Generation using Order User
    Given open NI URL
    When login in NI Application with Order User
    Then verify NI Subject Search page is displayed
    When click on Property tab in NI Subject Search page
    And enter Address '714 WHITLATCH DR, LANCASTER, CA 93535' in Property Tab of NI Subject Search page
    And click on Submit Request button in NI Subject Search page
    Then verify NI Property Report page is displayed
    When enable Loan Safe Suite in NI Property Report page
    And select 'Collateral Manager' in the Loan Safe Suite pop-up in NI Property Report page
    And click on VIEW ALL REPORTS button in NI Property Report page
    Then verify Report Summary Window is displayed in NI Property Report page
    When click on LoanSafe® Suite View button in Report Summary Window of NI Property Report page
    And switch to New window
    Then verify NI PXI Input page is displayed
    And verify the TEXT BOX is displayed with values in NI PXI Input page
      | Field Name     | Field Value      |
      | Street Address | 714 WHITLATCH DR |
      | City           | LANCASTER        |
      | State          | CA               |
      | Zip            | 93535            |
    When the TEXT BOX is filled with values in NI PXI Input page
      | Field Name      | Field Value              |
      | Estimated Value | 60,000                   |
      | Loan #          | [RANDOM --> LOAN NUMBER] |
    And click on Submit button in NI PXI Input page
    Then verify NI PXI Report page is displayed for Order User
    And verify PXI Report is displayed in NI PXI Report page
    And verify the Section is displayed in NI PXI Report page
      | Section - Report Information                     |
      | Section - Loan Information                       |
      | Section - Fraud Alerts                           |
      | Section - Property Detail                        |
      | Section - Recent Subject Property Resale Summary |
      | Section - Subject Property Report                |
      | Section - Nearby Properties Review               |
      | Section - Disclaimer                             |
    And verify the expected Field Value is displayed in NI PXI Report page
      | Field Name                         | Field Value                           |
      | RI - Report Order No.              | [NOT EMPTY]                           |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mm a]     |
      | RI - Standardized Property Address | 714 Whitlatch Dr\nLancaster, Ca 93535 |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]              |
      | LI - Reported Appraised Value      | $60,000                               |
