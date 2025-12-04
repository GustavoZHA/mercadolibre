package com.mercadolibre.ui.pages.common;

import com.core.ui.WebDriverManager;
import com.mercadolibre.ui.pages.BasePage;
import org.openqa.selenium.By;

public class BarPage extends BasePage {
    private By searchTextBox = By.cssSelector("input.nav-search-input");
    private By searchButton = By.cssSelector(".nav-search-btn");


    public BarPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void typeSearchTextBox(String value) {
        action.type(searchTextBox, value);
    }

    public void clickSearchButton() {
        action.click(searchButton);
    }


}
