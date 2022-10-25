package com.automation.ui.base;

import com.automation.ui.cucumber.TestContextDecorator;
import com.automation.ui.helpers.ElementName;
import com.automation.ui.helpers.Folding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePage extends TestContextDecorator {
    private String parentWindowHandle;
    private final Map<BasePage, Map<String, WebElement>> pageElementMap = new HashMap<>();

    protected void afterClassInstanceCreated() {
        PageFactory.initElements(getDriver(), this);
        putPageElementMap(this.getFieldElementMap());
    }

    protected Map<String, WebElement> getFieldElementMap() {
        Map<String, WebElement> elementsMap = new HashMap<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ElementName.class) && field.get(this) instanceof WebElement element) {
                    ElementName annotation = field.getDeclaredAnnotation(ElementName.class);
                    elementsMap.put(annotation.value(), element);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to Map the WebElement with Field Name. \nException: " + e.getMessage());
            }
        }
        return elementsMap;
    }

    protected void putPageElementMap(Map<String, WebElement> elementMap) {
        pageElementMap.put(this, elementMap);
    }

    private Map<String, WebElement> getPageElementMap(BasePage page) {
        return pageElementMap.get(page);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getElementText(String name) {
        return getPageElementMap(this).get(name).getText();
    }

    public void clickElement(String name) {
        getSeleniumActions().jsClick(getPageElementMap(this).get(name));
    }

    public void enterFieldValue(String field, String value) {
        getPageElementMap(this).get(field).sendKeys(value);
    }

    public String getFieldValue(String field) {
        return getPageElementMap(this).get(field).getAttribute("value");
    }

    public void selectDropdownValue(String field, String value) {
        getSeleniumActions().selectByVisibleText(getPageElementMap(this).get(field), value);
    }

    public boolean isElementDisplayed(String name) {
        try {
            return getPageElementMap(this).get(name).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private String initializeWindowHandle() {
        parentWindowHandle = getDriver().getWindowHandle();
        return parentWindowHandle;
    }

    public String getParentWindowHandle() {
        return (parentWindowHandle == null) ? initializeWindowHandle() : parentWindowHandle;
    }

    public void switchToParentWindow() {
        getDriver().switchTo().window(getParentWindowHandle());
    }

    public void switchToChildWindow() {
        Set<String> handles = getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equalsIgnoreCase(getParentWindowHandle())) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
    }

    protected WebElement replaceValueInXpathAndGetWebElement(String xpathPattern, String replaceValue) {
        By finalValue = replaceValueInXpathAndGetBy(xpathPattern, replaceValue);
        return getDriver().findElement(finalValue);
    }

    protected By replaceValueInXpathAndGetBy(String xpathPattern, String replaceValue) {
        String finalValue = xpathPattern.replace("<replace_value>", replaceValue);
        return By.xpath(finalValue);
    }

    public void doFolding(Folding action, List<String> sections) {
        sections.forEach(section -> {
            boolean isAlreadyExpanded = this.getElementText(section).startsWith("-");
            if ((isAlreadyExpanded && action.equals(Folding.COLLAPSE)) || (!isAlreadyExpanded && action.equals(Folding.EXPAND)))
                this.clickElement(section);
        });
    }
}