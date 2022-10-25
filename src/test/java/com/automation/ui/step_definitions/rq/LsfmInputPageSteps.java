package com.automation.ui.step_definitions.rq;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.helpers.Folding;
import com.automation.ui.pages.rq.LsfmInputPage;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class LsfmInputPageSteps extends BaseSteps {

    private final LsfmInputPage lsfmInputPage = getPageObject(LsfmInputPage.class);

    public LsfmInputPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify RQ LSFM Input page is displayed for (Order|Contract) User$")
    public void verifySearchPage(String user) {
        if (user.equals("Contract"))
            Assertions.assertThat(lsfmInputPage.getHeaderNameContractUser()).startsWith("LoanSafe Fraud Manager");
        else if (user.equals("Order"))
            Assertions.assertThat(lsfmInputPage.getHeaderNameOrderUser()).startsWith("LoanSafe Fraud Manager");
        Assertions.assertThat(lsfmInputPage.getTitle()).startsWith("RealQuest.com");
        takeScreenshot();
    }

    @When("click on Submit button in RQ LSFM Input page")
    public void clickSubmit() {
        lsfmInputPage.clickElement("Submit Button");
        getSeleniumActions().acceptAlertIfPresent();
    }

    @And("^click to (EXPAND|COLLAPSE) the sections in in RQ LSFM Input page$")
    public void clickSections(String action, List<String> sections) {
        lsfmInputPage.doFolding(Folding.valueOf(action), sections);
    }

    @When("the TEXT BOX is filled with values in RQ LSFM Input page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("ORDER" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            lsfmInputPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }

    @When("the DROP DOWN is filled with values in RQ LSFM Input page")
    public void selectValueInDropdown(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> lsfmInputPage.selectDropdownValue(it.getFieldName(), it.getFieldValue()));
    }
}