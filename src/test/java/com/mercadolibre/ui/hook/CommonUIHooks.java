package com.mercadolibre.ui.hook;

import com.core.ui.WebDriverBrowser;
import com.core.ui.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUIHooks {
    private WebDriverBrowser browser;
    private WebDriver driver;
    private static final String MEDIA_TYPE = "image/png";
    private static final String FILE_NAME = "screenshot";

    public CommonUIHooks(WebDriverManager webDriverManager) {
        browser = new WebDriverBrowser(webDriverManager);
        driver = webDriverManager.getWebDriver();
    }

    @After(value = "@gui")
    public void quitDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, MEDIA_TYPE, FILE_NAME);
        }
        browser.closeBrowser();
        browser.quitDriver();
    }
}
