package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.ElementName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PxiInputPage extends BasePage {

    @FindBy(id = "collateralTitle")
    private WebElement headerName;

    @FindBy(className = "btn btn-default btn-space")
    private WebElement clearButton;

    @ElementName("Submit Button")
    @FindBy(id = "validateSbmtBtn")
    private WebElement submitButton;

    //PXI Input Section
    @ElementName("Street Address")
    @FindBy(id = "LSC_address")
    private WebElement streetAddress;

    @ElementName("City")
    @FindBy(id = "LSC_city")
    private WebElement city;

    @ElementName("State")
    @FindBy(id = "LSC_state")
    private WebElement state;

    @ElementName("Zip")
    @FindBy(id = "LSC_zip")
    private WebElement zip;

    @ElementName("APN")
    @FindBy(id = "LSC_addressAPN")
    private WebElement apn;

    @ElementName("Estimated Value")
    @FindBy(id = "LSC_estimatedvalue")
    private WebElement estimatedValue;

    @ElementName("Loan #")
    @FindBy(id = "LSC_USER_LOAN_NUMBER")
    private WebElement loanNumber;

    @ElementName("Loan Purpose")
    @FindBy(id = "LSF_USER_PURPOSE_DESC")
    private WebElement loanPurposeDropdown;

    @ElementName("Branch Code")
    @FindBy(id = "LSC_BRANCH_CODE")
    private WebElement branchCode;

    public String getHeaderName() {
        getWait().until(ExpectedConditions.visibilityOf(headerName));
        return headerName.getText();
    }
}