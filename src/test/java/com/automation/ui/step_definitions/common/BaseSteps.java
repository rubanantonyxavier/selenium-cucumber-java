package com.automation.ui.step_definitions.common;

import com.automation.ui.base.BasePage;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.cucumber.TestContextDecorator;
import com.automation.ui.utils.ScreenshotUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseSteps extends TestContextDecorator {

    public BaseSteps(TestContext testContext) {
        initialize(testContext);
    }

    @SuppressWarnings("unchecked")
    protected final <T extends BasePage> T getPageObject(Class<T> clazz) {
        return (T) getPageMap().get(clazz);
    }

    public void takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        ScreenshotUtil.saveAsImage(screenshot);
    }
}