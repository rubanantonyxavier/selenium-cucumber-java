package com.automation.ui.step_definitions.rq;

import com.automation.ui.configuration.Config;
import com.automation.ui.step_definitions.common.BaseSteps;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.rq.LoginPage;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseSteps {

    private final LoginPage loginPage = getPageObject(LoginPage.class);

    public LoginPageSteps(TestContext testContext) {
        super(testContext);
    }

    @When("^login in RQ Application with (Order|Contract) User$")
    public void login(String user) {
        if (user.equalsIgnoreCase("Order"))
            loginPage.doLogin(Config.RQ_ORDER_USER, Config.RQ_ORDER_PSWD);
        else if (user.equalsIgnoreCase("Contract"))
            loginPage.doLogin(Config.RQ_CONTRACT_USER, Config.RQ_CONTRACT_PSWD);
    }
}