package com.automation.ui.step_definitions.ni;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.helpers.Folding;
import com.automation.ui.pages.ni.DaqInputPage;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class DaqInputPageSteps extends BaseSteps {

    private final DaqInputPage daqInputPage = getPageObject(DaqInputPage.class);

    public DaqInputPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify NI DAQ Input page is displayed for (Order|Contract) User$")
    public void verifySearchPage(String user) {
        if (user.equals("Contract"))
            Assertions.assertThat(daqInputPage.getHeaderNameContractUser()).startsWith("LoanSafe Fraud Manager");
        else if (user.equals("Order"))
            Assertions.assertThat(daqInputPage.getHeaderNameOrderUser()).startsWith("LoanSafe Fraud Manager");
        Assertions.assertThat(daqInputPage.getTitle()).startsWith("Engineer Ambitiously - NI");
        takeScreenshot();
    }

    @When("click on Submit button in NI DAQ Input page")
    public void clickSubmit() {
        daqInputPage.clickElement("Submit Button");
        getSeleniumActions().acceptAlertIfPresent();
    }

    @And("^click to (EXPAND|COLLAPSE) the sections in in NI DAQ Input page$")
    public void clickSections(String action, List<String> sections) {
        daqInputPage.doFolding(Folding.valueOf(action), sections);
    }

    @When("the TEXT BOX is filled with values in NI DAQ Input page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("ORDER" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            daqInputPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }

    @When("the DROP DOWN is filled with values in NI DAQ Input page")
    public void selectValueInDropdown(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> daqInputPage.selectDropdownValue(it.getFieldName(), it.getFieldValue()));
    }
}