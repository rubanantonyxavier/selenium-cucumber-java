package com.automation.ui.step_definitions.crm;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.helpers.Folding;
import com.automation.ui.pages.crm.OrderPage;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class OrderPageSteps extends BaseSteps {

    private final OrderPage orderPage = getPageObject(OrderPage.class);

    public OrderPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify CRM Order page is displayed")
    public void verifySearchPage() {
        Assertions.assertThat(orderPage.getTitle()).isEqualTo("Free CRM software");
        Assertions.assertThat(orderPage.getHeaderName()).startsWith("LoanSafe Fraud Manager");
        takeScreenshot();
    }

    @When("click on Submit button in CRM Order page")
    public void clickSubmit() {
        orderPage.clickElement("Submit Button");
    }

    @And("^click to (EXPAND|COLLAPSE) the sections in in CRM Order page$")
    public void clickSections(String action, List<String> sections) {
        orderPage.doFolding(Folding.valueOf(action), sections);
    }

    @When("the TEXT BOX is filled with values in CRM Order page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("Order" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            orderPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }

    @When("the DROP DOWN is filled with values in CRM Order page")
    public void selectValueInDropdown(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> orderPage.selectDropdownValue(it.getFieldName(), it.getFieldValue()));
    }
}