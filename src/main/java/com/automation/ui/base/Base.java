package com.automation.ui.base;

import com.automation.ui.cucumber.TestContext;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;

@Getter
public class Base {

    private TestContext testContext;

    public void initialize(TestContext testContext) {
        this.testContext = testContext;
    }

    public <T> T initializeClass(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException("Unable to Initialize the " + pageClass + ". \nException: " + e.getMessage());
        }
    }

    public <T extends BasePage> T initializeWithContext(Class<T> pageClass) {
        T instance = initializeClass(pageClass);
        instance.initialize(getTestContext());
        instance.afterClassInstanceCreated();
        return instance;
    }
}