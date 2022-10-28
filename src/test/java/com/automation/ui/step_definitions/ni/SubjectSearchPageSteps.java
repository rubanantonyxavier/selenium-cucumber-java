package com.automation.ui.step_definitions.ni;

import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ni.SubjectSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class SubjectSearchPageSteps extends BaseSteps {

    private final SubjectSearchPage subjectSearchPage = getPageObject(SubjectSearchPage.class);

    public SubjectSearchPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify NI Subject Search page is displayed")
    public void verifySubjectSearchPage() {
        Assertions.assertThat(subjectSearchPage.getTitle()).isEqualTo("RealQuest");
        Assertions.assertThat(subjectSearchPage.getSearchHeaderText()).isEqualTo("Search for Properties");
        takeScreenshot();
    }

    @When("^navigate to (Fraud Manager|Risk Manager) in Loan Safe Tab in NI Application$")
    public void selectInLoanSafeTab(String page) {
        subjectSearchPage.clickValueInTabLoanSafeDropdown(page);
    }

    @When("^click on (.*) tab in NI Subject Search page$")
    public void clickOnTabInSubjectSearch(String tab) {
        subjectSearchPage.clickTabInSubjectSearch(tab);
    }

    @And("^enter Address '(.*)' in Property Tab of NI Subject Search page$")
    public void enterValueInAddressFieldInPropertyTab(String value) {
        subjectSearchPage.enterAddressValueInPropertyTab(value);
        getTempVariables().setAddress(value);
    }

    @And("click on Submit Request button in NI Subject Search page")
    public void clickSubmitRequest() {
        subjectSearchPage.clickSubmitRequest();
    }
}