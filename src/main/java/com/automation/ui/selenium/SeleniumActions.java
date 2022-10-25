package com.automation.ui.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {

    private final WebDriver driver;
    private Actions actions;
    private JavascriptExecutor jsExecutor;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
    }

    private Actions initializeActions() {
        actions = new Actions(driver);
        return actions;
    }

    private Actions getActions() {
        return (actions == null) ? initializeActions() : actions;
    }

    private JavascriptExecutor initializeJsExecutor() {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor;
    }

    private JavascriptExecutor getJsExecutor() {
        return (jsExecutor == null) ? initializeJsExecutor() : jsExecutor;
    }

    private Select getSelect(WebElement element) {
        return new Select(element);
    }

    public void selectByVisibleText(WebElement element, String value) {
        getSelect(element).selectByVisibleText(value);
    }

    public void jsClick(WebElement element) {
        getJsExecutor().executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
        getJsExecutor().executeScript("arguments[0].click();", element);
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlertIfPresent() {
        if (isAlertPresent())
            driver.switchTo().alert().accept();
    }

    public void actionMoveToElement(WebElement element) {
        getActions().moveToElement(element).build().perform();
    }
}