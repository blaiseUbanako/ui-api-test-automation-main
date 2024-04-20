package com.ui.api.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfigReader {
    private static final Properties properties;

    static {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
