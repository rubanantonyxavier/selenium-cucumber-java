package com.automation.ui.cucumber;

import com.automation.ui.selenium.SeleniumActions;
import com.automation.ui.pojo.TempVariables;
import com.automation.ui.base.Base;
import com.automation.ui.base.BasePage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class TestContextDecorator extends Base {

    public final void setDriver(WebDriver driver) {
        getTestContext().setDriver(driver);
    }

    public final WebDriver getDriver() {
        return getTestContext().getDriver();
    }

    public final void setWait(WebDriverWait wait) {
        getTestContext().setWait(wait);
    }

    public final WebDriverWait getWait() {
        return getTestContext().getWait();
    }

    public final void setScenario(Scenario scenario) {
        getTestContext().setScenario(scenario);
    }

    public final Scenario getScenario() {
        return getTestContext().getScenario();
    }

    public final void setPageMap(Map<Class<? extends BasePage>, Object> pageMap) {
        getTestContext().setPageMap(pageMap);
    }

    public final Map<Class<? extends BasePage>, Object> getPageMap() {
        return getTestContext().getPageMap();
    }

    public final void setTempVariables(TempVariables tempVariables) {
        getTestContext().setTempVariables(tempVariables);
    }

    public final TempVariables getTempVariables() {
        return getTestContext().getTempVariables();
    }

    public final void setSeleniumActions(SeleniumActions seleniumActions) {
        getTestContext().setSeleniumActions(seleniumActions);
    }

    public final SeleniumActions getSeleniumActions() {
        return getTestContext().getSeleniumActions();
    }
}