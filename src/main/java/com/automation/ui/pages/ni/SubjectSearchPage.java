package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubjectSearchPage extends BasePage {

    //Header Section
    @FindBy(id = "rq_header")
    private WebElement header;
    @FindBy(id = "loansafe_link")
    private WebElement tabLoanSafeDropdown;
    private static final String TAB_LOAN_SAFE_DROPDOWN_VALUES = "//li[@id='tdLoanSafeSuite_Menu']//a[contains(text(),'<replace_value>')]";

    //Subject Search Page
    @FindBy(xpath = "//div[@id='search-page']/h1")
    private WebElement searchHeaderText;
    private static final String TAB_SUBJECT_SEARCH = "//a[(starts-with(@title,'Subject Search :')) and (contains(text(),'<replace_value>'))]";

    //Property Tab Section
    @FindBy(id = "smart_search_line")
    private WebElement propertyAddress;
    @FindBy(id = "validateSbmtBtn")
    private WebElement submitRequestButton;

    @Override
    public String getTitle() {
        getWait().until(ExpectedConditions.visibilityOf(header));
        return getDriver().getTitle();
    }

    public String getSearchHeaderText() {
        getWait().until(ExpectedConditions.visibilityOf(searchHeaderText));
        return searchHeaderText.getText();
    }

    public void clickValueInTabLoanSafeDropdown(String page) {
        tabLoanSafeDropdown.click();
        replaceValueInXpathAndGetWebElement(TAB_LOAN_SAFE_DROPDOWN_VALUES, page).click();
    }

    public void clickTabInSubjectSearch(String tab) {
        replaceValueInXpathAndGetWebElement(TAB_SUBJECT_SEARCH, tab).click();
    }

    public void enterAddressValueInPropertyTab(String value) {
        propertyAddress.sendKeys(value);
    }

    public void clickSubmitRequest() {
        submitRequestButton.click();
    }
}