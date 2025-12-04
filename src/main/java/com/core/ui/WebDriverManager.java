package com.core.ui;

import com.mercadolibre.EnvConfig;
import com.core.ui.driver.WebDriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebDriverManager {
    @Getter
    private WebDriver webDriver;
    @Getter
    private WebDriverWait wait;
    public final int MILLE_SECOND_50 = 50;

    public WebDriverManager() {
        initialize();
    }

    private void initialize() {
        webDriver = WebDriverFactory.getDriver(EnvConfig.getBrowser());
        setDefaultImplicitWait();
        setDefaultExplicitWait();
        setDefaultPollingEvery();
    }

    public void setDefaultImplicitWait() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(Long.parseLong(EnvConfig.getImplicitTime())));
    }

    public void setDefaultExplicitWait() {
        wait = new WebDriverWait(webDriver, Duration.ofMillis(Long.parseLong(EnvConfig.getExplicitTime())));
    }

    public void setDefaultPollingEvery() {
        wait.pollingEvery(Duration.ofMillis(MILLE_SECOND_50));
    }
}
