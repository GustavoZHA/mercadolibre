package com.mercadolibre.ui.pages.search;

import com.core.ui.WebDriverManager;
import com.mercadolibre.ui.pages.BasePage;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private By itemsResultSearch = By.cssSelector(".ui-search-layout--grid li");
    private By imgResultSearch = By.cssSelector(".poly-card__portada img");
    private By descriptionResultSearch = By.cssSelector(".poly-component__title");
    private By priceResultSearch = By.cssSelector(".poly-component__price");
    private By messageNullResult = By.cssSelector(".ui-search-rescue__title");

    public SearchPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public int getNumberItemsResult() {
        return action.getElements(itemsResultSearch).size();
    }
    public int getNumberImgResults() {
        return action.getElements(imgResultSearch).size();
    }
    public int getNumberDescriptionResult() {
        return action.getElements(descriptionResultSearch).size();
    }
    public int getNumberPriceResult() {
        return action.getElements(priceResultSearch).size();
    }

    public String getResultNullText() {
        return action.getTextOfElement(messageNullResult);
    }

}
