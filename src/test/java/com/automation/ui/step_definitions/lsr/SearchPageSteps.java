package com.automation.ui.step_definitions.lsr;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.lsr.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class SearchPageSteps extends BaseSteps {

    private final SearchPage searchPage = getPageObject(SearchPage.class);

    public SearchPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify LSR Search page is displayed")
    public void verifySearchPage() {
        Assertions.assertThat(searchPage.getHeaderName()).isEqualTo("Search Transactions");
        Assertions.assertThat(searchPage.getTitle()).isEqualTo("LoanSafe Reporter");
        takeScreenshot();
    }

    @When("the TEXT BOX is filled with values in LSR Search page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> searchPage.enterFieldValue(it.getFieldName(), it.getFieldValue()));
    }

    @When("click on Submit button in LSR Search page")
    public void clickSubmit() {
        searchPage.clickElement("Submit Button");
    }

    @Then("verify LSR Search Result page is displayed")
    public void verifySearchResultPage() {
        Assertions.assertThat(searchPage.isSearchResultTableDisplayed()).isTrue();
        takeScreenshot();
    }

    @When("click on SignOut in LSR")
    public void logOut() {
        searchPage.doLogOut();
    }

    @When("^click on (Search Tab|Order Tab) in LSR$")
    public void clickHeaderTab(String headerTab) {
        searchPage.clickElement(headerTab);
    }
}