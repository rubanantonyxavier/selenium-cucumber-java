package com.automation.ui.step_definitions.lsr;

import com.automation.ui.configuration.Config;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.lsr.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LoginPageSteps extends BaseSteps {

    private final LoginPage loginPage = getPageObject(LoginPage.class);

    public LoginPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify LSR Login page is displayed")
    public void verifyLoginPage() {
        Assertions.assertThat(loginPage.getTitle()).isEqualTo("LoanSafe Reporter");
        takeScreenshot();
    }

    @When("login in LSR Application")
    public void login() {
        loginPage.doLogin(Config.LSR_CONTRACT_USER, Config.LSR_CONTRACT_PSWD);
    }

    @Then("logout page is displayed in LSR")
    public void verifyLogoutPage() {
        Assertions.assertThat(loginPage.getLogOutText()).isEqualTo("Logged Out");
        takeScreenshot();
    }
}