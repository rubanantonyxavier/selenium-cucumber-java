package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LabInputPage extends BasePage {

    @FindBy(id = "fraudRiskReissueTitle")
    private WebElement headerNameContractUser;

    @FindBy(id = "riskTitle")
    private WebElement headerNameOrderUser;

    @FindBy(className = "btn btn-default btn-space")
    private WebElement clearButton;

    @ElementName("Submit Button")
    @FindBy(id = "validateSbmtBtn")
    private WebElement submitButton;

    //Section Expand or Collapse
    @ElementName("Primary Borrower Information")
    @FindBy(id = "lsr_includeBorrower")
    private WebElement borrowerSection;

    @ElementName("Real Estate Owned Information")
    @FindBy(id = "LSR_uptoproperty")
    private WebElement reoSection;

    @ElementName("Co-Borrower Information")
    @FindBy(id = "lsr_includeCoBorrower")
    private WebElement coBorrowerSection;

    @ElementName("Third Borrower Information")
    @FindBy(id = "lsr_includeThirdBorrower")
    private WebElement thirdBorrowerSection;

    @ElementName("Fourth Borrower Information")
    @FindBy(id = "lsr_includeFourthBorrower")
    private WebElement fourthBorrowerSection;

    @ElementName("Fifth Borrower Information")
    @FindBy(id = "lsr_includeFifthBorrower")
    private WebElement fifthBorrowerSection;

    @ElementName("Sixth Borrower Information")
    @FindBy(id = "lsr_includeSixthBorrower")
    private WebElement sixthBorrowerSection;

    @ElementName("Loan Data Information")
    @FindBy(id = "lsr_loanData")
    private WebElement loanDataSection;

    @ElementName("MLO Information")
    @FindBy(id = "LSR_uptooriginator")
    private WebElement mloSection;

    @ElementName("Add Appraiser Information")
    @FindBy(id = "LSR_uptoappraiser")
    private WebElement appraiserSection;

    @ElementName("Add Loan Actors")
    @FindBy(id = "LSR_uptoloanactor")
    private WebElement loanActorsSection;

    //LAB Input Section
    @ElementName("Street Address")
    @FindBy(id = "LSR_address")
    private WebElement streetAddress;

    @ElementName("City")
    @FindBy(id = "LSR_city")
    private WebElement city;

    @ElementName("State")
    @FindBy(id = "LSR_state")
    private WebElement state;

    @ElementName("Zip")
    @FindBy(id = "LSR_zip")
    private WebElement zip;

    @ElementName("County")
    @FindBy(id = "LSR_USER_PROP_COUNTY")
    private WebElement country;

    @ElementName("APN")
    @FindBy(id = "LSR_addressAPN")
    private WebElement apn;

    @ElementName("Estimated Value")
    @FindBy(id = "LSR_CUST_ESTIMATE")
    private WebElement estimatedValue;

    @ElementName("Property Type")
    @FindBy(id = "LSR_USER_PROP_TYPE_DESC")
    private WebElement propertyTypeDropdown;

    @ElementName("Occupancy Type")
    @FindBy(id = "LSR_USER_OCC_TYPE_DESC")
    private WebElement occupancyTypeDropdown;

    @ElementName("Sale Price")
    @FindBy(id = "LSR_USER_SALE_AMOUNT")
    private WebElement salePrice;

    @ElementName("Seller Name")
    @FindBy(id = "LSR_USER_PROPERTY_SELLER")
    private WebElement sellerName;

    //Primary Borrower Information Section
    @ElementName("First Name")
    @FindBy(id = "LSR_firstname")
    private WebElement firstName;

    @ElementName("Middle Name")
    @FindBy(id = "LSR_middlename")
    private WebElement middleName;

    @ElementName("Last Name")
    @FindBy(id = "LSR_lastname")
    private WebElement lastName;

    @ElementName("Suffix")
    @FindBy(id = "LSR_suffix")
    private WebElement suffix;

    @ElementName("SSN1")
    @FindBy(id = "LSR_ssn1")
    private WebElement ssn1;

    @ElementName("SSN2")
    @FindBy(id = "LSR_ssn2")
    private WebElement ssn2;

    @ElementName("SSN3")
    @FindBy(id = "LSR_ssn3")
    private WebElement ssn3;

    @ElementName("Phone #")
    @FindBy(id = "LSR_currentphoneno")
    private WebElement phoneNumber;

    @ElementName("DOB")
    @FindBy(id = "LSR_dob")
    private WebElement dob;

    @ElementName("Current Address")
    @FindBy(id = "LSR_currentaddress")
    private WebElement currentAddress;

    @ElementName("Current City")
    @FindBy(id = "LSR_currentcity")
    private WebElement currentCity;

    @ElementName("Current State")
    @FindBy(id = "LSR_currentstate")
    private WebElement currentState;

    @ElementName("Current Zip")
    @FindBy(id = "LSR_currentzip")
    private WebElement currentZip;

    @ElementName("Employment Type")
    @FindBy(id = "LSR_emptype")
    private WebElement employmetTypeDropdown;

    @ElementName("Employer Name")
    @FindBy(id = "LSR_employername")
    private WebElement employerName;

    @ElementName("Monthly Income")
    @FindBy(id = "LSR_baseincome")
    private WebElement monthlyIncome;

    //Real Estate Owned Information Section
    @ElementName("REO Street Address")
    @FindBy(id = "LSR_REO0_STREETADDRESS")
    private WebElement reoStreetAddress;

    @ElementName("REO City")
    @FindBy(id = "LSR_REO0_CITY")
    private WebElement reoCity;

    @ElementName("REO State")
    @FindBy(id = "LSR_REO0_STATE")
    private WebElement reoState;

    @ElementName("REO Zip")
    @FindBy(id = "LSR_REO0_ZIP")
    private WebElement reoZip;

    @ElementName("REO Property Disposition Status")
    @FindBy(id = "LSR_REO0_DISPOSITIONSTATUS")
    private WebElement reoPropertyDispositionStatusDropdown;

    @ElementName("REO Property Type")
    @FindBy(id = "LSR_REO0_PROPERTYTYPE")
    private WebElement reoPropertyTypeDropdown;

    @ElementName("REO Current Residence")
    @FindBy(id = "LSR_REO0_CURRENTRESIDENCE")
    private WebElement reoCurrentResidenceDropdown;

    @ElementName("REO Gross Rental Income")
    @FindBy(id = "LSR_REO0_GROSSINCOME")
    private WebElement reoGrossRentalIncome;

    //Loan Data Information Section
    @ElementName("LD Business Channel")
    @FindBy(id = "LSR_CHANNEL_CODE")
    private WebElement ldBusinessChannelDropdown;

    @ElementName("LD Loan #")
    @FindBy(id = "LSR_USER_LOAN_NUMBER")
    private WebElement ldLoanNumber;

    @ElementName("LD Loan Amount")
    @FindBy(id = "LSR_USER_LOAN_AMOUNT")
    private WebElement ldLoanAmount;

    @ElementName("LD Loan Program")
    @FindBy(id = "LSR_USER_LOAN_PROD_DESC")
    private WebElement ldLoanProgramDropDown;

    @ElementName("LD Loan Purpose")
    @FindBy(id = "LSR_USER_PURPOSE_DESC")
    private WebElement ldLoanPurposeDropdown;

    @ElementName("LD Loan Status")
    @FindBy(id = "LSR_USER_LOAN_STATUS")
    private WebElement ldLoanStatusDropdown;

    @ElementName("LD Document Type")
    @FindBy(id = "LSR_USER_DOC_TYPE_DESC")
    private WebElement ldDocumentTypeDropdown;

    @ElementName("LD Lien Type")
    @FindBy(id = "LSR_USER_LIEN_DESC")
    private WebElement ldLienTypeDropdown;

    @ElementName("LD Loan-to-Value")
    @FindBy(id = "LSR_USER_LTV")
    private WebElement ldLoanToValue;

    @ElementName("LD Debt-to-Income")
    @FindBy(id = "LSR_USER_DTI")
    private WebElement ldDebtToIncome;

    @ElementName("LD Combined Loan-to-Value")
    @FindBy(id = "LSR_USER_CLTV")
    private WebElement ldCombinedLoanToValue;

    @ElementName("LD Front End Ratio")
    @FindBy(id = "LSR_USER_FRONT_END_RATIO")
    private WebElement ldFrontEndRatio;

    @ElementName("LD Monthly PITI")
    @FindBy(id = "LSR_USER_PITI")
    private WebElement ldMonthlyPITI;

    @ElementName("LD Application Date")
    @FindBy(id = "LSR_USER_APPLICATION_DATE")
    private WebElement ldApplicationDate;

    @ElementName("LD Loan Term")
    @FindBy(id = "LSR_USER_TERM")
    private WebElement ldLoanTerm;

    @ElementName("LD Interest Rate")
    @FindBy(id = "LSR_USER_INT_RATE")
    private WebElement ldInterestRate;

    @ElementName("LD Cash Out Amount")
    @FindBy(id = "LSR_USER_CASH_OUT_AMT")
    private WebElement ldCashOutAmount;

    public String getHeaderNameContractUser() {
        getWait().until(ExpectedConditions.visibilityOf(headerNameContractUser));
        return headerNameContractUser.getText();
    }

    public String getHeaderNameOrderUser() {
        getWait().until(ExpectedConditions.visibilityOf(headerNameOrderUser));
        return headerNameOrderUser.getText();
    }
}