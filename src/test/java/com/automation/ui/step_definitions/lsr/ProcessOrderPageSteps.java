package com.automation.ui.step_definitions.lsr;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.lsr.ProcessOrderPage;
import com.automation.ui.utils.AssertionUtil;
import com.automation.ui.utils.CustomStringUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class ProcessOrderPageSteps extends BaseSteps {

    private final ProcessOrderPage processOrderPage = getPageObject(ProcessOrderPage.class);

    public ProcessOrderPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify LSR Process Order page is displayed")
    public void verifyProcessOrderPage() {
        Assertions.assertThat(processOrderPage.getTitle()).isEqualTo("LoanSafe Reporter");
        Assertions.assertThat(processOrderPage.isElementDisplayed("Section - USV Header")).isTrue();
        takeScreenshot();
    }

    @Then("verify LSFM Report is displayed in LSR Process Order page")
    public void verifySearchPage() {
        Assertions.assertThat(processOrderPage.isElementDisplayed("Section - LSFM Report")).isTrue();
        Assertions.assertThat(processOrderPage.isElementDisplayed("Section - LSFM Report Header")).isTrue();
        takeScreenshot();
    }

    @And("verify the expected Field Value is displayed in LSR Process Order page")
    public void verifyExpectedFieldValue(List<FieldTable> fieldTable) {
        SoftAssertions.assertSoftly(softly -> fieldTable.forEach(it -> {
            String extractedText = processOrderPage.getElementText(it.getFieldName());
            if (it.getFieldValue().equals("[NOT EMPTY]")) {
                AssertionUtil.assertFieldValueNotEmpty(softly, it.getFieldName(), extractedText);
            } else if (it.getFieldValue().startsWith("[MATCH -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                AssertionUtil.assertFieldValueMatchesRegex(softly, it.getFieldName(), extractedText, expectedFormat);
            } else {
                if (it.getFieldValue().startsWith("[VERIFY -->")) {
                    String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                    if (expectedFormat.equals("LOAN NUMBER"))
                        it.setFieldValue(getTempVariables().getLoanNumber());
                }
                AssertionUtil.assertFieldValueEqualsExpected(softly, it.getFieldName(), it.getFieldValue(), extractedText);
            }
        }));
    }
}