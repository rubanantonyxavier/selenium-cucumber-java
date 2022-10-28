package com.automation.ui.step_definitions.ni;

import com.automation.ui.configuration.Config;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.ni.LoginPage;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseSteps {

    private final LoginPage loginPage = getPageObject(LoginPage.class);

    public LoginPageSteps(TestContext testContext) {
        super(testContext);
    }

    @When("^login in NI Application with (Order|Contract) User$")
    public void login(String user) {
        if (user.equalsIgnoreCase("Order"))
            loginPage.doLogin(Config.NI_ORDER_USER, Config.NI_ORDER_PSWD);
        else if (user.equalsIgnoreCase("Contract"))
            loginPage.doLogin(Config.NI_CONTRACT_USER, Config.NI_CONTRACT_PSWD);
    }
}