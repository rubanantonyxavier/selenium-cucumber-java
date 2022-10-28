package com.automation.ui.pages.ni;

import com.automation.ui.base.BasePage;
import com.automation.ui.helpers.UserAvailability;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@id='loginForm']//button[@type='submit']")
    private WebElement signInButton;

    @Override
    public String getTitle() {
        getWait().until(ExpectedConditions.visibilityOf(signInButton));
        return getDriver().getTitle();
    }

    public void doLogin(String userName, String password) {
        UserAvailability.setUserStatusAsInUse(userName);
        getTempVariables().setUserInUse(userName);
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}