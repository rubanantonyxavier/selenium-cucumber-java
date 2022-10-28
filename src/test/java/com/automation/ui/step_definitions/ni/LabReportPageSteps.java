package com.automation.ui.step_definitions.ni;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ni.LabReportPage;
import com.automation.ui.utils.AssertionUtil;
import com.automation.ui.utils.CustomStringUtil;
import com.automation.ui.utils.DateUtil;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class LabReportPageSteps extends BaseSteps {

    private final LabReportPage labReportPage = getPageObject(LabReportPage.class);

    public LabReportPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify NI LAB Report page is displayed for (Order|Contract) User$")
    public void verifyProcessOrderPage(String user) {
        Assertions.assertThat(labReportPage.getTitle()).startsWith("Engineer Ambitiously - NI");
        if (user.equals("Contract"))
            Assertions.assertThat(labReportPage.isElementDisplayed("Section - USV Header")).isTrue();
        takeScreenshot();
    }

    @Then("verify LAB Report is displayed in NI LAB Report page")
    public void verifySearchPage() {
        Assertions.assertThat(labReportPage.isElementDisplayed("Section - LAB Report")).isTrue();
        Assertions.assertThat(labReportPage.isElementDisplayed("Section - LAB Report Header")).isTrue();
        takeScreenshot();
    }

    @Then("verify the Section is displayed in NI LAB Report page")
    public void isSectionDisplayed(List<String> sections) {
        SoftAssertions.assertSoftly(softly -> {
            for (String section : sections) {
                boolean isSectionFound = labReportPage.isElementDisplayed(section);
                AssertionUtil.assertSectionFound(softly, section, isSectionFound);
            }
        });
    }

    @Then("verify the expected Field Value is displayed in NI LAB Report page")
    public void verifyExpectedFieldValue(List<FieldTable> fieldTable) {
        SoftAssertions.assertSoftly(softly -> fieldTable.forEach(it -> {
            String extractedText = labReportPage.getElementText(it.getFieldName());
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