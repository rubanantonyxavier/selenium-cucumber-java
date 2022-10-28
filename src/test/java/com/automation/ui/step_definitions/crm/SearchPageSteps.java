package com.automation.ui.step_definitions.crm;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.crm.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class SearchPageSteps extends BaseSteps {

    private final SearchPage searchPage = getPageObject(SearchPage.class);

    public SearchPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify CRM Search page is displayed")
    public void verifySearchPage() {
        Assertions.assertThat(searchPage.getHeaderName()).isEqualTo("Search Transactions");
        Assertions.assertThat(searchPage.getTitle()).isEqualTo("Free CRM software");
        takeScreenshot();
    }

    @When("the TEXT BOX is filled with values in CRM Search page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> searchPage.enterFieldValue(it.getFieldName(), it.getFieldValue()));
    }

    @When("click on Submit button in CRM Search page")
    public void clickSubmit() {
        searchPage.clickElement("Submit Button");
    }

    @Then("verify CRM Search Result page is displayed")
    public void verifySearchResultPage() {
        Assertions.assertThat(searchPage.isSearchResultTableDisplayed()).isTrue();
        takeScreenshot();
    }

    @When("click on SignOut in CRM")
    public void logOut() {
        searchPage.doLogOut();
    }

    @When("^click on (Search Tab|Order Tab) in CRM$")
    public void clickHeaderTab(String headerTab) {
        searchPage.clickElement(headerTab);
    }
}