package com.automation.ui.step_definitions.rq;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.rq.LscmReportPage;
import com.automation.ui.utils.AssertionUtil;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.DateUtil;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class LscmReportPageSteps extends BaseSteps {

    private final LscmReportPage lscmReportPage = getPageObject(LscmReportPage.class);

    public LscmReportPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("^verify RQ LSCM Report page is displayed for (Order|Contract) User$")
    public void verifyProcessOrderPage(String user) {
        Assertions.assertThat(lscmReportPage.getTitle()).startsWith("RealQuest.com");
        if (user.equals("Contract"))
            Assertions.assertThat(lscmReportPage.isElementDisplayed("Section - USV Header")).isTrue();
        takeScreenshot();
    }

    @Then("verify LSCM Report is displayed in RQ LSCM Report page")
    public void verifySearchPage() {
        Assertions.assertThat(lscmReportPage.isElementDisplayed("Section - LSCM Report")).isTrue();
        Assertions.assertThat(lscmReportPage.isElementDisplayed("Section - LSCM Report Header")).isTrue();
        takeScreenshot();
    }

    @Then("verify the Section is displayed in RQ LSCM Report page")
    public void isSectionDisplayed(List<String> sections) {
        SoftAssertions.assertSoftly(softly -> {
            for (String section : sections) {
                boolean isSectionFound = lscmReportPage.isElementDisplayed(section);
                AssertionUtil.assertSectionFound(softly, section, isSectionFound);
            }
        });
    }

    @Then("verify the expected Field Value is displayed in RQ LSCM Report page")
    public void verifyExpectedFieldValue(List<FieldTable> fieldTable) {
        SoftAssertions.assertSoftly(softly -> fieldTable.forEach(it -> {
            String extractedText = lscmReportPage.getElementText(it.getFieldName()).trim();
            if (it.getFieldValue().equals("[NOT EMPTY]")) {
                AssertionUtil.assertFieldValueNotEmpty(softly, it.getFieldName(), extractedText);
            } else if (it.getFieldValue().startsWith("[MATCH -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                AssertionUtil.assertFieldValueMatchesRegex(softly, it.getFieldName(), extractedText, expectedFormat);
            } else if (it.getFieldValue().startsWith("[DATETIME -->")) {
                String expectedFormat = CustomStringUtil.getFieldPattern(it.getFieldValue());
                boolean isValidFormat = DateUtil.isValidDateTimeFormat(expectedFormat, extractedText);
                AssertionUtil.assertFieldValueDisplayedExpectedFormat(softly, it.getFieldName(), extractedText, expectedFormat, isValidFormat);
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