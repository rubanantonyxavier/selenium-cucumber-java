package com.automation.ui.configuration;

import com.automation.ui.configuration.env.EnvConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Config {
    public final String ALLURE_PROPERTIES_FILENAME = "build/allure-results/environment.properties";
    public final String ENV = System.getenv("ENV") != null
            ? System.getenv("ENV")
            : "QA";
    public final String ENV_CONFIG_LOCATION = "src/main/resources/config-%s.yaml".formatted(ENV.toLowerCase());
    public final String BRANCH = System.getenv("BRANCH") != null
            ? System.getenv("BRANCH")
            : "master";
    public final String BROWSER = System.getenv("BROWSER") != null
            ? System.getenv("BROWSER")
            : "CHROME";
    private static final String HEADLESS_BROWSER_ENV_VAR_KEY = "headless_browser";
    public final boolean HEADLESS_BROWSER = (System.getenv(HEADLESS_BROWSER_ENV_VAR_KEY) != null
            && !"false".equalsIgnoreCase(System.getenv(HEADLESS_BROWSER_ENV_VAR_KEY)))
            || (System.getProperty(HEADLESS_BROWSER_ENV_VAR_KEY) != null)
            && !"false".equalsIgnoreCase(System.getProperty(HEADLESS_BROWSER_ENV_VAR_KEY));
    public final int TIMEOUT_SEC = 30;
    public final String CRM_CONTRACT_USER = System.getenv("CRM_CONTRACT_USER");
    public final String CRM_CONTRACT_PSWD = System.getenv("CRM_CONTRACT_PSWD");
    public final String NI_ORDER_USER = System.getenv("NI_ORDER_USER");
    public final String NI_ORDER_PSWD = System.getenv("NI_ORDER_PSWD");
    public final String NI_CONTRACT_USER = System.getenv("NI_CONTRACT_USER");
    public final String NI_CONTRACT_PSWD = System.getenv("NI_CONTRACT_PSWD");
    private @Getter @Setter EnvConfig envConfig;
}