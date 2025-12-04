package com.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverBrowser {
    private static WebDriverManager driverManager;
    private WebDriver driver;

    public WebDriverBrowser(WebDriverManager webDriverManager) {
        this.driverManager = webDriverManager;
        driver = driverManager.getWebDriver();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitDriver() {
        driver.quit();
    }
}
