package com.core.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverAction {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverManager webDriverManager;

    public WebDriverAction(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        driver = webDriverManager.getWebDriver();
        wait = webDriverManager.getWait();
    }

    public WebElement getWebElement(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void clickWithJavaScript(By element) {
        WebElement webElement = driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void clickWithAction(By selector) {
        WebElement el = driver.findElement(selector);
        Actions builder = new Actions(driver);
        builder.moveToElement(el).click(el);
        builder.perform();
    }

    public void type(final By selector, final String input) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.findElement(selector).clear();
        if(!"[clean]".equals(input)) driver.findElement(selector).sendKeys(input);
        else  {
            driver.findElement(selector).sendKeys(Keys.SPACE);
            driver.findElement(selector).sendKeys(Keys.DELETE);
        }
    }

    public void typeAndClick(final By selector, final String input) {
        driver.findElement(selector).sendKeys(Keys.CONTROL + "a");
        driver.findElement(selector).sendKeys(Keys.DELETE);
        click(selector);
        if (!"".equals(input) & !input.isEmpty()) driver.findElement(selector).sendKeys(input);
    }

    public List<WebElement> getElements(By selector) {
        return driver.findElements(selector);
    }

    public void clearTxtBox(By selector) {
        driver.findElement(selector).clear();
    }

    public void keysToSend(By element, CharSequence... keysToSend) {
        driver.findElement(element).sendKeys(keysToSend);
    }

    public String getTextOfElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public boolean isElementVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

    public String getCssValue(By element, String propertyName) {
        return driver.findElement(element).getCssValue(propertyName);
    }

    public String getAttribute(By element, String attributeName) {
        return driver.findElement(element).getAttribute(attributeName);
    }

    public WebElement findTheElement(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    public List<WebElement> findTheElements(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElements(selector);
    }

    public void clearTextBox(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement webElement = driver.findElement(element);
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void changeFrame(By element) {
        WebElement frameElement = driver.findElement(element);
        driver.switchTo().frame(frameElement);
    }

    public void scrollDownToTheBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollDownToElement(By element) {
        WebElement webElement = driver.findElement(element);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public boolean isTextBoxEnable(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement webElement = driver.findElement(element);
        return webElement.isEnabled();
    }
}
