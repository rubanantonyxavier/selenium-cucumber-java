package com.automation.ui.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@UtilityClass
public class FilesUtil {
    /**
     * Get the String content from the provided File
     *
     * @param file file to get the String
     * @return String body
     */
    @SneakyThrows(IOException.class)
    public String readFile(File file) {
        return Files.readString(file.toPath(), StandardCharsets.UTF_8);
    }
}
