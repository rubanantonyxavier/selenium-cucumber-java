package com.automation.ui.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@UtilityClass
public class DateUtil {

    /**
     * Evaluates if the provided Date Value is expected Format
     *
     * @param expectedFormat expected Date and Time Format
     * @param actualValue    actual value of Date and Time
     * @return true if the Actual value of Date and Time Format is the Expected one
     * @author Ruban
     */
    public boolean isValidDateTimeFormat(String expectedFormat, String actualValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat, Locale.ENGLISH);
        try {
            LocalDateTime ldt = LocalDateTime.parse(actualValue, formatter);
            String result = ldt.format(formatter);
            return result.equals(actualValue);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Evaluates if the provided Date Value is expected Format
     *
     * @param expectedFormat expected Date Format
     * @param actualValue    actual value of Date
     * @return true if the Actual value of Date Format is the Expected one
     * @author Ruban
     */
    public boolean isValidDateFormat(String expectedFormat, String actualValue) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat, Locale.ENGLISH);
        try {
            LocalDate ldt = LocalDate.parse(actualValue, formatter);
            String result = ldt.format(formatter);
            return result.equals(actualValue);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
