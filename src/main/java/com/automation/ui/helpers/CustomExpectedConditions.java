package com.automation.ui.helpers;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@UtilityClass
public class CustomExpectedConditions {
    public ExpectedCondition<Boolean> anyElementClickable(final List<By> elements) {
        return new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver driver) {
                for (By locator : elements) {
                    WebElement element = ExpectedConditions.visibilityOfElementLocated(locator).apply(driver);
                    try {
                        return element != null && element.isEnabled();
                    } catch (StaleElementReferenceException e) {
                        return false;
                    }
                }
                return false;
            }

            @Override
            public String toString() {
                return "visibility of any of " + elements;
            }
        };
    }
}
