package com.core.ui.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

public final class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    private WebDriverFactory() {
    }

    public static WebDriver getDriver(final String type) {
        switch (type) {
            case "CHROME":
                return new ChromeBrowser().getWebDriver();
            case "EDGE":
                return new EdgeBrowser().getWebDriver();
            case "FIREFOX":
                return new FirefoxBrowser().getWebDriver();
            default:
                logger.error(String.format("The browser %s is invalid", type));
                throw new InvalidArgumentException("Unsupported WebDriver");
        }
    }
}