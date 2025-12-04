package com.mercadolibre.ui.pages;

import com.core.ui.WebDriverAction;
import com.core.ui.WebDriverBrowser;
import com.core.ui.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriverManager webDriverManager;
    protected WebDriverAction action;
    protected WebDriverBrowser browser;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        action = new WebDriverAction(webDriverManager);
        browser = new WebDriverBrowser(webDriverManager);
        webDriver = webDriverManager.getWebDriver();
        webDriverWait = webDriverManager.getWait();
    }
}
