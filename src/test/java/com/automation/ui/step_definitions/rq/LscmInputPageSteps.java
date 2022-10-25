package com.automation.ui.step_definitions.rq;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.rq.LscmInputPage;
import com.automation.ui.utils.AssertionUtil;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.RandomUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class LscmInputPageSteps extends BaseSteps {

    private final LscmInputPage lscmInputPage = getPageObject(LscmInputPage.class);

    public LscmInputPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify RQ LSCM Input page is displayed")
    public void verifySearchPage() {
        Assertions.assertThat(lscmInputPage.getHeaderName()).endsWith("Collateral Manager Input Information");
        Assertions.assertThat(lscmInputPage.getTitle()).startsWith("RealQuest.com");
        takeScreenshot();
    }

    @When("click on Submit button in RQ LSCM Input page")
    public void clickSubmit() {
        lscmInputPage.clickElement("Submit Button");
        getSeleniumActions().acceptAlertIfPresent();
    }

    @Then("verify the TEXT BOX is displayed with values in RQ LSCM Input page")
    public void verifyValueInTextBox(List<FieldTable> fieldTable) {
        SoftAssertions.assertSoftly(softly -> fieldTable.forEach(it -> {
            String extractedText = lscmInputPage.getFieldValue(it.getFieldName());
            AssertionUtil.assertFieldValueEqualsExpected(softly, it.getFieldName(), it.getFieldValue(), extractedText);
        }));
        takeScreenshot();
    }

    @When("the TEXT BOX is filled with values in RQ LSCM Input page")
    public void enterValueInTextBox(List<FieldTable> fieldTable) {
        fieldTable.forEach(it -> {
            if (it.getFieldValue().startsWith("[RANDOM -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                if (expectedFormat.equals("LOAN NUMBER")) {
                    it.setFieldValue("ORDER" + RandomUtil.getRandomNumber(99999));
                    getTempVariables().setLoanNumber(it.getFieldValue());
                }
            }
            lscmInputPage.enterFieldValue(it.getFieldName(), it.getFieldValue());
        });
    }
}