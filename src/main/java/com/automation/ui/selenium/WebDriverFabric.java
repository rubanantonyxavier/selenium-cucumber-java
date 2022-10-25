package com.automation.ui.selenium;

import com.automation.ui.configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

@UtilityClass
public class WebDriverFabric {
    public WebDriver launchBrowser() {
        WebDriver driver = chooseWebDriver();

        driver.manage().window().setPosition(new Point(0, 0));
        if (Config.HEADLESS_BROWSER) {
            driver.manage().window().setSize(new Dimension(1124, 768));
        } else {
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Config.TIMEOUT_SEC, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Config.TIMEOUT_SEC, TimeUnit.SECONDS);

        return driver;
    }

    private WebDriver chooseWebDriver() {
        if ("FIREFOX".equalsIgnoreCase(Config.BROWSER)) {
            return launchFirefoxDriver();
        } else {
            return launchChromeDriver();
        }
    }

    private WebDriver launchChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(Config.HEADLESS_BROWSER);
        chromeOptions.addArguments("--disable-dev-shm-usage");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver launchFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setHeadless(Config.HEADLESS_BROWSER);
        return new FirefoxDriver(ffOptions);
    }
}