package com.automation.ui.helpers;

import com.automation.ui.configuration.Config;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class UserAvailability {
    private final Map<String, Boolean> userStatus = new HashMap<>();

    static {
        userStatus.put(Config.CRM_CONTRACT_USER, false);
        userStatus.put(Config.NI_CONTRACT_USER, false);
        userStatus.put(Config.NI_ORDER_USER, false);
    }

    public synchronized void setUserStatusAsInUse(String user) {
        waitUntilUserStatusAsNotInUse(user);
        userStatus.put(user, true);
    }

    public void setUserStatusAsNotInUse(String user) {
        userStatus.put(user, false);
    }

    private void waitUntilUserStatusAsNotInUse(String user) {
        while (Boolean.TRUE.equals(userStatus.get(user))) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}