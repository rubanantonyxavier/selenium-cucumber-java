@ui
@ni
@lab
Feature: NI - LAB Report Generation And Validation

  @contract
  Scenario: Verify NI - LAB Report Generation using Contract User
    Given open NI URL
    When login in NI Application with Contract User
    Then verify NI Subject Search page is displayed
    When navigate to Risk Manager in Loan Safe Tab in NI Application
    And switch to New window
    Then verify NI LAB Input page is displayed for Contract User
    And click to EXPAND the sections in in NI LAB Input page
      | Primary Borrower Information  |
      | Real Estate Owned Information |
      | Loan Data Information         |
    When the TEXT BOX is filled with values in NI LAB Input page
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
      | SSN1                      | 555                      |
      | SSN2                      | 695                      |
      | SSN3                      | 7777                     |
      | Phone #                   | 7787772321               |
      | DOB                       | 10/10/1980               |
      | Current Address           | 6720 COHNSON CIR         |
      | Current City              | WOLFHILL                 |
      | Current State             | AK                       |
      | Current Zip               | 58970                    |
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
    And the DROP DOWN is filled with values in NI LAB Input page
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
    And click on Submit button in NI LAB Input page
    Then verify NI LAB Report page is displayed for Contract User
    And verify LAB Report is displayed in NI LAB Report page
    And verify the Section is displayed in NI LAB Report page
      | Section - Information1       |
      | Section - Information2       |
      | Section - Search Summary     |
      | Section - Fraud Alert Header |
      | Section - Fraud Alert Table  |
      | Section - Property Detail    |
      | Section - Identity Detail    |
      | Section - Income Detail      |
      | Section - Borrower Detail    |
      | Section - Third Party Detail |
      | Section - Market Detail      |
      | Section - Disclaimer         |
    And verify the expected Field Value is displayed in NI LAB Report page
      | Field Name                         | Field Value                             |
      | USV - Report Order No.             | [NOT EMPTY]                             |
      | USV - Street Address               | 202 HARTNELL PL                         |
      | USV - City, State, Zip             | SACRAMENTO CA,95825                     |
      | RI - Report Order No.              | [NOT EMPTY]                             |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mma]        |
      | RI - Standardized Property Address | 202 Hartnell Pl\nSacramento, Ca 95825   |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]                |
      | BI - Pri-Borrower                  | GOLDETTA, ROWENA M, fr                  |
      | EI - Employer                      | Renal                                   |
      | FA - Fraud Risk Score              | [MATCH --> FRAUD RISK SCORE:  \\d{1,3}] |

  @order
  Scenario: Verify NI - LAB Report Generation using Order User
    Given open NI URL
    When login in NI Application with Order User
    Then verify NI Subject Search page is displayed
    When navigate to Risk Manager in Loan Safe Tab in NI Application
    And switch to New window
    Then verify NI LAB Input page is displayed for Order User
    And click to EXPAND the sections in in NI LAB Input page
      | Primary Borrower Information  |
      | Real Estate Owned Information |
      | Loan Data Information         |
    When the TEXT BOX is filled with values in NI LAB Input page
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
      | SSN1                      | 666                      |
      | SSN2                      | 44                       |
      | SSN3                      | 7777                     |
      | Phone #                   | 7787772321               |
      | DOB                       | 10/10/1980               |
      | Current Address           | 6720 COHNSON CIR         |
      | Current City              | WOLFHILL                 |
      | Current State             | AK                       |
      | Current Zip               | 58970                    |
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
    And the DROP DOWN is filled with values in NI LAB Input page
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
    And click on Submit button in NI LAB Input page
    Then verify NI LAB Report page is displayed for Order User
    And verify LAB Report is displayed in NI LAB Report page
    And verify the Section is displayed in NI LAB Report page
      | Section - Information1       |
      | Section - Information2       |
      | Section - Search Summary     |
      | Section - Fraud Alert Header |
      | Section - Fraud Alert Table  |
      | Section - Property Detail    |
      | Section - Identity Detail    |
      | Section - Income Detail      |
      | Section - Borrower Detail    |
      | Section - Third Party Detail |
      | Section - Market Detail      |
      | Section - Disclaimer         |
    And verify the expected Field Value is displayed in NI LAB Report page
      | Field Name                         | Field Value                             |
      | RI - Report Order No.              | [NOT EMPTY]                             |
      | RI - Report Date                   | [DATETIME --> MMM d, yyyy h:mma]        |
      | RI - Standardized Property Address | 202 Hartnell Pl\nSacramento, Ca 95825   |
      | LI - Loan Number                   | [VERIFY --> LOAN NUMBER]                |
      | BI - Pri-Borrower                  | GOLDETTA, ROWENA M, fr                  |
      | EI - Employer                      | Renal                                   |
      | FA - Fraud Risk Score              | [MATCH --> FRAUD RISK SCORE:  \\d{1,3}] |
