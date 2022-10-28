package com.automation.ui.step_definitions.ni;

import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ni.PropertyReportPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class PropertyReportPageSteps extends BaseSteps {

    private final PropertyReportPage propertyReportPage = getPageObject(PropertyReportPage.class);

    public PropertyReportPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify NI Property Report page is displayed")
    public void verifyPropertyReportPage() {
        Assertions.assertThat(propertyReportPage.isReportSubmitButtonVisible("VIEW REPORT", "VIEW ALL REPORTS"))
                .overridingErrorMessage("The Report Submit Button with name \"VIEW REPORT\" or \"VIEW ALL REPORTS\" is not displayed")
                .isTrue();
        Assertions.assertThat(propertyReportPage.getAddressInHeaderText()).isEqualToIgnoringCase(getTempVariables().getAddress());
        Assertions.assertThat(propertyReportPage.getTitle()).isEqualTo("RealQuest");
        takeScreenshot();
    }

    @When("enable Loan Safe Suite in NI Property Report page")
    public void enableLoanSafeSuite() {
        propertyReportPage.enableLoanSafeSuite();
    }

    @And("^select '(Collateral Manager|Fraud Manager|Risk Manager)' in the Loan Safe Suite pop-up in NI Property Report page$")
    public void selectLoanSafeSuite(String option) {
        propertyReportPage.selectLoanSafeSuiteOption(option);
        takeScreenshot();
    }

    @And("^click on (BUY/VIEW ALL REPORTS|VIEW ALL REPORTS|VIEW REPORT|BUY REPORT) button in NI Property Report page$")
    public void clickReportButton(String buttonName) {
        propertyReportPage.clickReportButton(buttonName);
    }

    @Then("verify Report Summary Window is displayed in NI Property Report page")
    public void verifyReportSummaryWindowDisplayed() {
        Assertions.assertThat(propertyReportPage.getReportSummaryWindowHeader()).isEqualTo("Report Summary");
        takeScreenshot();
    }

    @When("^click on (.*) View button in Report Summary Window of NI Property Report page$")
    public void clickViewInReportSummary(String report) {
        propertyReportPage.clickViewInReportSummary(report);
    }
}