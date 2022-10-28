package com.automation.ui.step_definitions.ni;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ni.PxiInputPage;
import com.automation.ui.utils.AssertionUtil;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class PxiInputPageSteps extends BaseSteps {

    private final PxiInputPage pxiInputPage = getPageObject(PxiInputPage.class);

    public PxiInputPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify NI PXI Input page is displayed")
    public void verifySearchPage() {
        Assertions.assertThat(pxiInputPage.getHeaderName()).endsWith("Collateral Manager Input Information");
        Assertions.assertThat(pxiInputPage.getTitle()).startsWith("Engineer Ambitiously - NI");
        takeScreenshot();
    }

    @When("click on Submit button in NI PXI Input page")
    public void clickSubmit() {
        pxiInputPage.clickElement("Submit Button");
        getSeleniumActions().acceptAlertIfPresent();
    }

    @Then("verify the TEXT BOX is displayed with values in NI PXI Input page")
    public void verifyValueInTextBox(List<FieldTable> fieldTable) {
        SoftAssertions.assertSoftly(softly -> fieldTable.forEach(it -> {
            String extractedText = pxiInputPage.getFieldValue(it.getFieldName());
            AssertionUtil.assertFieldValueEqualsExpected(softly, it.getFieldName(), it.getFieldValue(), extractedText);
        }));
        takeScreenshot();
    }

    @When("the TEXT BOX is filled with values in NI PXI Input page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("ORDER" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            pxiInputPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }
}