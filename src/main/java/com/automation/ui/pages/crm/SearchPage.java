package com.automation.ui.pages.crm;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    //Elements in Header section
    @ElementName("Search Tab")
    @FindBy(linkText = "Search")
    private WebElement searchTab;

    @ElementName("Order Tab")
    @FindBy(linkText = "Order")
    private WebElement orderTab;

    @FindBy(xpath = "//button[@id='dropdownMenuButton']/span")
    private WebElement profileDropdown;

    @FindBy(className = "dropdown-item")
    private WebElement signOutButton;

    //Elements In Search page
    @FindBy(xpath = "//font[@class='processing']")
    private WebElement headerName;

    @ElementName("Street Address")
    @FindBy(name = "address")
    private WebElement streetAddress;

    @ElementName("City")
    @FindBy(name = "city")
    private WebElement city;

    @ElementName("State")
    @FindBy(name = "state")
    private WebElement state;

    @ElementName("Zip")
    @FindBy(name = "zip")
    private WebElement zip;

    @ElementName("Date Processed From")
    @FindBy(name = "dateprocessedfrom")
    private WebElement dateProcessedFrom;

    @ElementName("Date Processed To")
    @FindBy(name = "dateprocessedto")
    private WebElement dateProcesseedTo;

    @ElementName("Loan #")
    @FindBy(name = "loanno")
    private WebElement loanNumber;

    @ElementName("Borrower Last Name")
    @FindBy(name = "lastname")
    private WebElement lastName;

    @ElementName("Borrower First Name")
    @FindBy(name = "firstname")
    private WebElement firstName;

    @ElementName("Borrower SSN1")
    @FindBy(id = "ssn1")
    private WebElement ssn1;

    @ElementName("Borrower SSN2")
    @FindBy(id = "ssn2")
    private WebElement ssn2;

    @ElementName("Borrower SSN3")
    @FindBy(id = "ssn3")
    private WebElement ssn3;

    @ElementName("JobID 1")
    @FindBy(name = "jobid1")
    private WebElement jobId1;

    @ElementName("CL Tracking ID")
    @FindBy(name = "trackingid")
    private WebElement trackingId;

    @ElementName("Order Number")
    @FindBy(name = "orderno")
    private WebElement orderNumber;

    //Buttons In Search page
    @ElementName("Submit Button")
    @FindBy(id = "validateSbmtBtn")
    private WebElement submitButton;

    @ElementName("Clear Button")
    @FindBy(css = ".btn.btn-default.btn-space")
    private WebElement clearButton;

    //Elements in Search Result page
    @FindBy(id = "tbl_loansafearchivelist")
    private WebElement searchResultTable;

    public String getHeaderName() {
        getWait().until(ExpectedConditions.visibilityOf(headerName));
        return headerName.getText();
    }

    public boolean isSearchResultTableDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(searchResultTable));
        return searchResultTable.isDisplayed();
    }

    public void doLogOut() {
        getWait().until(ExpectedConditions.visibilityOf(profileDropdown));
        profileDropdown.click();
        signOutButton.click();
    }
}