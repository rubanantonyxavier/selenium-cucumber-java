@ui
@crm
@order
Feature: CRM - Order

  Scenario: Verify CRM - Order is successful
    Given open CRM URL
    Then verify CRM Login page is displayed
    When login in CRM Application
    Then verify CRM Search page is displayed
    When click on Order Tab in CRM
    And switch to New window
    Then verify CRM Order page is displayed
    And click to EXPAND the sections in in CRM Order page
      | Primary Borrower Information  |
      | Real Estate Owned Information |
      | Loan Data Information         |
    When the TEXT BOX is filled with values in CRM Order page
      | Field Name                | Field Value              |
      | Street Address            | 202 hartnell pl          |
      | City                      | sacramento               |
      | State                     | ca                       |
      | Zip                       | 95825                    |
      | Estimated Value           | 800,000                  |
      | Sale Price                | 890,000                  |
      | Seller Name               | AK Realty                |
      | First Name                | ROWENA                   |
      | Middle Name               | M                        |
      | Last Name                 | GOLDETTA                 |
      | Suffix                    | fr                       |
      | SSN1                      | 000                      |
      | SSN2                      | 11                       |
      | SSN3                      | 2222                     |
      | Phone #                   | 7787772321               |
      | DOB                       | 10/10/1980               |
      | Current Address           | 6720 COHNSON CIR         |
      | Current City              | WOLFHILL                 |
      | Current State             | AK                       |
      | Current Zip               | 5897                     |
      | Employer Name             | Renal                    |
      | Monthly Income            | 1,000                    |
      | REO Street Address        | 1343  euclid             |
      | REO City                  | santa ana                |
      | REO State                 | ca                       |
      | REO Zip                   | 92703                    |
      | REO Gross Rental Income   | 8,883                    |
      | LD Loan #                 | [RANDOM --> LOAN NUMBER] |
      | LD Loan Amount            | 400,000                  |
      | LD Loan-to-Value          | 44                       |
      | LD Debt-to-Income         | 44                       |
      | LD Combined Loan-to-Value | 66                       |
      | LD Front End Ratio        | 77                       |
      | LD Monthly PITI           | 55                       |
      | LD Application Date       | 10/10/2021               |
      | LD Loan Term              | 1                        |
      | LD Interest Rate          | 5                        |
      | LD Cash Out Amount        | 60,000                   |
    And the DROP DOWN is filled with values in CRM Order page
      | Field Name                      | Field Value                           |
      | Property Type                   | PUD                                   |
      | Occupancy Type                  | Primary Residence                     |
      | Employment Type                 | Not Employed (student, retired, etc.) |
      | REO Property Disposition Status | Sold                                  |
      | REO Property Type               | New Construction                      |
      | REO Current Residence           | Yes                                   |
      | LD Business Channel             | Wholesale                             |
      | LD Loan Program                 | Conventional                          |
      | LD Loan Purpose                 | Cash Out Refinance                    |
      | LD Loan Status                  | Application                           |
      | LD Document Type                | Full doc                              |
      | LD Lien Type                    | First                                 |
    And click on Submit button in CRM Order page
    Then verify CRM Process Order page is displayed
    And verify DAQ Report is displayed in CRM Process Order page
    And verify the expected Field Value is displayed in CRM Process Order page
      | Field Name             | Field Value                             |
      | USV - Report Order No. | [NOT EMPTY]                             |
      | USV - Street Address   | 202 HARTNELL PL                         |
      | USV - City, State, Zip | SACRAMENTO CA,95825                     |
      | RI - Report Order No.  | [NOT EMPTY]                             |
      | LI - Loan Number       | [VERIFY --> LOAN NUMBER]                |
      | BI - Pri-Borrower      | GOLDETTA, ROWENA M, fr                  |
      | EI - Employer          | Renal                                   |
      | FA - Fraud Risk Score  | [MATCH --> FRAUD RISK SCORE:  \\d{1,3}] |
