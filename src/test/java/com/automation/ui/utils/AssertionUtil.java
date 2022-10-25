package com.automation.ui.utils;

import lombok.experimental.UtilityClass;
import org.assertj.core.api.SoftAssertions;

@UtilityClass
public class AssertionUtil {

    public void assertSectionFound(SoftAssertions softly, String sectionName, boolean isSectionFound) {
        softly.assertThat(isSectionFound)
                .as("The Section Name: \"%s\"", sectionName)
                .overridingErrorMessage("\n  expected: found\n    actual: not found")
                .isTrue();
    }

    public void assertFieldValueNotEmpty(SoftAssertions softly, String fieldName, String extractedText) {
        softly.assertThat(extractedText)
                .as(createFieldNameAssertionMessage(fieldName))
                .overridingErrorMessage("\n  expected: Text Content is Available\n    actual: Text Content is Not Available")
                .isNotEmpty();
    }

    public void assertFieldValueMatchesRegex(SoftAssertions softly, String fieldName, String extractedText, String expectedFormat) {
        softly.assertThat(extractedText)
                .as(createFieldNameAssertionMessage(fieldName))
                .overridingErrorMessage("\n  expected to match regex: \"%s\"\n                   actual: \"%s\"", expectedFormat, extractedText)
                .matches(expectedFormat);
    }

    public void assertFieldValueDisplayedExpectedFormat(SoftAssertions softly, String fieldName, String extractedText, String expectedFormat, boolean isValidFormat) {
        softly.assertThat(isValidFormat)
                .as(createFieldNameAssertionMessage(fieldName))
                .overridingErrorMessage("\n  expected format: \"%s\" \n           actual: \"%s\"", expectedFormat, extractedText)
                .isTrue();
    }

    public void assertFieldValueEqualsExpected(SoftAssertions softly, String fieldName, String fieldValue, String extractedText) {
        softly.assertThat(extractedText)
                .as(createFieldNameAssertionMessage(fieldName))
                .overridingErrorMessage("\n  expected: \"%s\"\n    actual: \"%s\"", fieldValue, extractedText)
                .isEqualTo(fieldValue);
    }

    private String createFieldNameAssertionMessage(String fieldName) {
        return "Text Value extracted by \"%s\" Field Name".formatted(fieldName);
    }
}