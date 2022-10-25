package com.automation.ui.step_definitions;

import com.automation.ui.utils.PropertiesFacade;
import com.automation.ui.configuration.Config;
import com.automation.ui.configuration.env.EnvConfig;
import com.automation.ui.pojo.TempVariables;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.base.BasePage;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.helpers.UserAvailability;
import com.automation.ui.selenium.SeleniumActions;
import com.automation.ui.selenium.WebDriverFabric;
import com.automation.ui.utils.FilesUtil;
import com.automation.ui.utils.ScreenshotUtil;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reflections.Reflections;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CucumberHooks extends BaseSteps {

    public CucumberHooks(TestContext testContext) {
        super(testContext);
    }

    @BeforeAll
    public static void beforeAll() {
        loadEnvironmentalConfig();
    }

    @Before("@ui")
    public void setup(Scenario scenario) {
        launchBrowser();
        setScenario(scenario);
        initializePages();
    }

    @After("@ui")
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            ScreenshotUtil.saveAsImage(screenshot);
        }
        if (getTempVariables().getUserInUse() != null) {
            UserAvailability.setUserStatusAsNotInUse(getTempVariables().getUserInUse());
        }
        getDriver().quit();
    }

    @AfterAll
    public static void afterAllTests() throws IOException {
        collectAllureEnvInfo();
    }

    private static void collectAllureEnvInfo() throws IOException {
        PropertiesFacade properties = new PropertiesFacade();
        properties.putIfNotNull("ENV", Config.ENV);
        properties.putIfNotNull("URL", Config.getEnvConfig().getUrls().toString());
        properties.putIfNotNull("BRANCH", Config.BRANCH);
        properties.putIfNotNull("BROWSER", Config.BROWSER);
        properties.store(new FileWriter(Config.ALLURE_PROPERTIES_FILENAME), "Execution Details");
    }

    private static void loadEnvironmentalConfig() {
        Path configPath = Paths.get(Config.ENV_CONFIG_LOCATION);
        Constructor constructor = new Constructor(EnvConfig.class);
        Yaml yaml = new Yaml(constructor);
        Config.setEnvConfig(yaml.load(FilesUtil.readFile(configPath.toFile())));
    }

    private void launchBrowser() {
        WebDriver driver = WebDriverFabric.launchBrowser();
        WebDriverWait wait = new WebDriverWait(driver, Config.TIMEOUT_SEC);
        setDriver(driver);
        setWait(wait);
    }

    private void initializePages() {
        setSeleniumActions(new SeleniumActions(getDriver()));
        setTempVariables(initializeClass(TempVariables.class));
        Map<Class<? extends BasePage>, Object> pageMap = new HashMap<>();
        Reflections reflections = new Reflections("com.automation.ui.pages");
        ArrayList<Class<? extends BasePage>> classList = new ArrayList<>(reflections.getSubTypesOf(BasePage.class));
        classList.forEach(clazz -> pageMap.put(clazz, initializeWithContext(clazz)));
        setPageMap(pageMap);
    }
}