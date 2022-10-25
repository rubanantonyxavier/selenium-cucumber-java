package com.automation.ui.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.security.SecureRandom;

@UtilityClass
public class RandomUtil {

    @SneakyThrows
    public int getRandomNumber(int maxDigit) {
        return SecureRandom.getInstanceStrong().nextInt(maxDigit);
    }
}