package com.automation.ui.utils;

import java.util.Properties;

public class PropertiesFacade extends Properties {
    public void putIfNotNull(String key, String value) {
        if (null != value) {
            super.put(key, value);
        }
    }
}
