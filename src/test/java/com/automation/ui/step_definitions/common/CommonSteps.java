package com.automation.ui.step_definitions.common;

import com.automation.ui.pojo.datatable.FieldTable;
import com.automation.ui.cucumber.TestContext;
import com.automation.ui.pages.common.CommonPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Map;

public class CommonSteps extends BaseSteps {

    private final CommonPage commonPage = getPageObject(CommonPage.class);

    public CommonSteps(TestContext testContext) {
        super(testContext);
    }

    @DataTableType(replaceWithEmptyString = "[empty]")
    public FieldTable fieldTableConvert(Map<String, String> entry) {
        return new FieldTable(
                entry.get("Field Name"),
                entry.get("Field Value")
        );
    }

    @Given("^open (NI|CRM) URL$")
    public void openUrl(String ui) {
        getDriver().get(commonPage.getUrl(ui));
    }

    @And("^switch to (New|Default) window$")
    public void switchWindow(String window) {
        commonPage.switchWindow(window);
    }
}