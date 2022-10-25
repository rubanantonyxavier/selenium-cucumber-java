package com.automation.ui.utils;

import io.qameta.allure.Allure;
import lombok.experimental.UtilityClass;

import java.io.ByteArrayInputStream;

@UtilityClass
public class ScreenshotUtil {

    /**
     * Attach Image in Allure Report
     *
     * @param screenshot Image as Byte Array
     * @author Ruban
     */
    public static void saveAsImage(byte[] screenshot) {
        Allure.addAttachment("Screenshot Image", new ByteArrayInputStream(screenshot));
    }
}