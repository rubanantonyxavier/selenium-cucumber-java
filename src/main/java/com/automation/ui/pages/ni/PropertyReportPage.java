package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.CustomExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class PropertyReportPage extends BasePage {

    //Header Section
    @FindBy(xpath = "//div[@class='report-header']")
    private WebElement reportHeaderSection;
    @FindBy(xpath = "//div[@class='report-header']/div[2]/div[1]/div")
    private WebElement reportHeaderAddress;

    //Mortgage Analytics Section
    @FindBy(xpath = "//input[@id='loansafe']/following-sibling::label")
    private WebElement loanSafeSuiteCheckBox;
    @FindBy(id = "LoanSafeOptions")
    private WebElement loanSafeSuiteOptionsWindow;
    private static final String LOAN_SAFE_SUITE_OPTION = "//div[@id='LoanSafeOptions']//span[text()='<replace_value>']";

    //Report Summary Window
    @FindBy(id = "modal-report-summary")
    private WebElement reportSummaryWindow;
    @FindBy(xpath = "//div[@class='modal-header']/p")
    private WebElement reportSummaryWindowHeader;
    private static final String REPORT_SUMMARY_WINDOW_VIEW_BUTTON = "//label[text()='<replace_value>']/../..//a[@class='btn btn-default col-md-12']";

    //Report Submit button
    private static final String REPORT_BUTTON = "//a[@id='report_submit_button'][text()='<replace_value>']";

    public boolean isReportSubmitButtonVisible(String... buttonNames) {

        List<By> buttons = Arrays.stream(buttonNames)
                .map(this::getReportButtonElementBy)
                .toList();

        return getWait().until(CustomExpectedConditions.anyElementClickable(buttons));
    }

    public String getAddressInHeaderText() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(reportHeaderSection, reportHeaderAddress));
        return reportHeaderAddress.getText();
    }

    public void enableLoanSafeSuite() {
        getSeleniumActions().jsClick(loanSafeSuiteCheckBox);
    }

    public void selectLoanSafeSuiteOption(String option) {
        getWait().until(ExpectedConditions.visibilityOf(loanSafeSuiteOptionsWindow));
        replaceValueInXpathAndGetWebElement(LOAN_SAFE_SUITE_OPTION, option).click();
    }

    public void clickReportButton(String buttonName) {
        getReportButtonElement(buttonName).click();
    }

    public String getReportSummaryWindowHeader() {
        getWait().until(ExpectedConditions.visibilityOf(reportSummaryWindow));
        return reportSummaryWindowHeader.getText();
    }

    public void clickViewInReportSummary(String report) {
        replaceValueInXpathAndGetWebElement(REPORT_SUMMARY_WINDOW_VIEW_BUTTON, report).click();
    }

    private WebElement getReportButtonElement(String buttonName) {
        return replaceValueInXpathAndGetWebElement(REPORT_BUTTON, buttonName);
    }
    private By getReportButtonElementBy(String buttonName) {
        return replaceValueInXpathAndGetBy(REPORT_BUTTON, buttonName);
    }
}