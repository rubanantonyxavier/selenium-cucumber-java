package com.automation.ui.pages.common;

import com.automation.ui.configuration.Config;
import com.automation.ui.base.BasePage;

public class CommonPage extends BasePage {

    /**
     * To get the URL based on provided Application name
     *
     * @param ui UI Application name
     * @return URL as String
     */
    public String getUrl(String ui) {
        return switch (ui) {
            case "NI" -> Config.getEnvConfig().getUrls().getNiUI();
            case "CRM" -> Config.getEnvConfig().getUrls().getCrmUI();
            default -> throw new RuntimeException(ui + " - The provided Application URL is not available");
        };
    }

    /**
     * To Switch to New/Default Window
     *
     * @param window Window Option as String
     */
    public void switchWindow(String window) {
        if (window.equals("New"))
            switchToChildWindow();
        else if (window.equals("Default"))
            switchToParentWindow();
    }
}