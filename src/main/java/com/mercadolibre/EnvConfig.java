package com.mercadolibre;

import com.core.utils.config.PropertiesReader;
import lombok.Getter;

import java.util.ArrayList;

public class EnvConfig {
    @Getter
    private static String adminUser;
    @Getter
    private static String adminPassword;
    @Getter
    private static String browser;
    @Getter
    private static String implicitTime;
    @Getter
    private static String explicitTime;
    @Getter
    private static String baseUrl;
    @Getter
    private static String executeIn = "LOCAL";

    static {
        try {
            getEnvironmentProperties();
        } catch (Exception e) {
            getEnvironmentSystem();
        }
    }

    private static void getEnvironmentProperties() {
        PropertiesReader user = new PropertiesReader("environments/users.properties");
        adminUser = user.getProperty("ADMIN_USER");
        adminPassword = user.getProperty("ADMIN_PASSWORD");

        PropertiesReader properties = new PropertiesReader("environments/config.properties");
        browser = properties.getProperty("BROWSER");
        implicitTime = properties.getProperty("IMPLICIT_TIME");
        explicitTime = properties.getProperty("EXPLICIT_TIME");
        baseUrl = properties.getProperty("BASE_URL");
    }

    private static void getEnvironmentSystem() {
        adminUser = System.getenv("ADMIN_USER");
        adminPassword = System.getenv("ADMIN_PASSWORD");
        executeIn = System.getenv("EXECUTE_IN");

        browser = System.getenv("BROWSER");
        implicitTime = System.getenv("IMPLICIT_TIME");
        explicitTime = System.getenv("EXPLICIT_TIME");
        baseUrl = System.getenv("BASE_URL");
    }
}
