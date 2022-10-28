package com.automation.ui.pages.crm;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.UserAvailability;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//form[@id='loginForm']//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//p[@class='line'][2]/b")
    private WebElement logOutNotification;

    @Override
    public String getTitle() {
        getWait().until(ExpectedConditions.visibilityOf(signInButton));
        return getDriver().getTitle();
    }

    public void doLogin(String user, String pass) {
        UserAvailability.setUserStatusAsInUse(user);
        getTempVariables().setUserInUse(user);
        username.sendKeys(user);
        password.sendKeys(pass);
        signInButton.click();
    }

    public String getLogOutText() {
        getWait().until(ExpectedConditions.visibilityOf(logOutNotification));
        return logOutNotification.getText();
    }
}