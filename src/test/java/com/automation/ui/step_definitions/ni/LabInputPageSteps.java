package com.automation.ui.step_definitions.ni;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.helpers.Folding;
import com.automation.ui.pages.ni.LabInputPage;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class LabInputPageSteps extends BaseSteps {

    private final LabInputPage labInputPage = getPageObject(LabInputPage.class);

    public LabInputPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify NI LAB Input page is displayed for (Order|Contract) User$")
    public void verifySearchPage(String User) {
        if (User.equals("Contract"))
            Assertions.assertThat(labInputPage.getHeaderNameContractUser()).startsWith("LoanSafe Risk Manager");
        else if (User.equals("Order"))
            Assertions.assertThat(labInputPage.getHeaderNameOrderUser()).startsWith("LoanSafe Risk Manager");
        Assertions.assertThat(labInputPage.getTitle()).startsWith("Engineer Ambitiously - NI");
        takeScreenshot();
    }

    @When("click on Submit button in NI LAB Input page")
    public void clickSubmit() {
        labInputPage.clickElement("Submit Button");
        getSeleniumActions().acceptAlertIfPresent();
    }

    @And("^click to (EXPAND|COLLAPSE) the sections in in NI LAB Input page$")
    public void clickSections(String action, List<String> sections) {
        labInputPage.doFolding(Folding.valueOf(action), sections);
    }

    @When("the TEXT BOX is filled with values in NI LAB Input page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("ORDER" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            labInputPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }

    @When("the DROP DOWN is filled with values in NI LAB Input page")
    public void selectValueInDropdown(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> labInputPage.selectDropdownValue(it.getFieldName(), it.getFieldValue()));
    }
}