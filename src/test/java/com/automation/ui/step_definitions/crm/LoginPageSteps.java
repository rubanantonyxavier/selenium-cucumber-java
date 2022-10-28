package com.automation.ui.step_definitions.crm;

import com.automation.ui.configuration.Config;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.crm.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LoginPageSteps extends BaseSteps {

    private final LoginPage loginPage = getPageObject(LoginPage.class);

    public LoginPageSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("verify CRM Login page is displayed")
    public void verifyLoginPage() {
        Assertions.assertThat(loginPage.getTitle()).isEqualTo("Free CRM software");
        takeScreenshot();
    }

    @When("login in CRM Application")
    public void login() {
        loginPage.doLogin(Config.CRM_CONTRACT_USER, Config.CRM_CONTRACT_PSWD);
    }

    @Then("logout page is displayed in CRM")
    public void verifyLogoutPage() {
        Assertions.assertThat(loginPage.getLogOutText()).isEqualTo("Logged Out");
        takeScreenshot();
    }
}