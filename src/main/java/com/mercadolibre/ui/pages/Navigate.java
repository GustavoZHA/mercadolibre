package com.mercadolibre.ui.pages;

import com.core.ui.WebDriverManager;
import com.mercadolibre.EnvConfig;

import java.util.Map;

public class Navigate extends BasePage {
    private Map<String, String> urls = Map.of(
            "Bolivia", EnvConfig.getBaseUrl()
    );
    public Navigate(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void to(String reference) {
        browser.navigate(urls.get(reference));
    }

}
