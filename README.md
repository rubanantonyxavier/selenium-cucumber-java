# Test Automation Framework for Web UI Applications
This is the Test Automation framework for Web UI Applications using Selenium WebDriver, Cucumber, Pico-container, Gradle & Allure Report

## Run tests
Use `cucumber` gradle-task for running tests

### Examples:
`gradle clean cucumber allureServe` - run all tests in single thread and load the Allure Report

`gradle clean cucumber -P tags="@crm" -P threads=10` - run only _lsr_ tests in parallel in 10 threads

`gradle allureServe` - to load the Allure Report

To run UI tests in headless browser, add either `-Dheadless_browser` flag to execution command or add a `headless_browser` env var with any value except `false`

E.g.: `gradle clean cucumber -P tags="@ui"` - tests run in usual browser mode

`gradle clean cucumber -P tags="@ui" -Dheadless_browser=false` - tests run in usual browser mode

`gradle clean cucumber -P tags="@ui" -Dheadless_browser` - tests run in headless browser mode

### Env:
Environment can be specified with the `ENV` environment variable:
```properties
ENV=QA
```

Services URLs are specified in environmental config files:
```shell
src/main/resources/config-dev.yaml
src/main/resources/config-qa.yaml
src/main/resources/config-uat.yaml
```

### Browser:
To run UI tests the `BROWSER` environment variable should have `CHROME` or `FIREFOX` value accordingly. In case the env var is not specified, **Chrome** browser wil be used.
```properties
BROWSER=CHROME
```
Also, as an alternative to `-Dheadless_browser` system property, it is possible to use the `headless_browser` env var to run UI tests in headless browser:
```properties
headless_browser=true
```

### Credentials:
Creds are set with environment variables:
```properties
###For CRM###
CRM_CONTRACT_USER
CRM_CONTRACT_PSWD

###For NI###
NI_ORDER_USER
NI_ORDER_PSWD
NI_CONTRACT_USER
NI_CONTRACT_PSWD
```

### Scenario filtering:
`-P tags=@crm` - to run scenario with _@lsr_ tag only,

`-P tags="@crm and @ni"` - to run only scenarios with both the _@lsr_ and _@rq_ tags

`-P tags="@crm or @ni"` - to run only scenarios with either the _@lsr_ or _@rq_ tags

`-P tags="@ui and not @ni"` - to run `@ui` tests and exclude `@ni` tags

### Parallel running:
`-P threads=10`

## Tests development

### Tags:
You can mark a scenario with any tag for filtering purpose. A scenario can have any number of tags. Cucumber tags are inherited by hierarchy:
1. Feature
2. Scenario
3. Examples

A tag can be defined on each of these levels. Examples have all the tags that were defined on Scenario scope. Scenarios have tags defined on their Feature scope.

Please follow this convention:
* tag should start with `@` character
* tag name is lowercase
* if tag is more than one word, use `_` character as a space
* Tags in cucumber-java are case-sensitive
