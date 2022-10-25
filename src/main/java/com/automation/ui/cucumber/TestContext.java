package com.automation.ui.cucumber;

import com.automation.ui.pojo.TempVariables;
import com.automation.ui.selenium.SeleniumActions;
import com.automation.ui.base.BasePage;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

@Getter
@Setter
public class TestContext {

    private WebDriver driver;
    private WebDriverWait wait;
    private Scenario scenario;
    private Map<Class<? extends BasePage>, Object> pageMap;
    private TempVariables tempVariables;
    private SeleniumActions seleniumActions;
}