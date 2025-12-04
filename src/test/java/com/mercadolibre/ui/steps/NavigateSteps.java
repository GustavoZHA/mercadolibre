package com.mercadolibre.ui.steps;

import com.mercadolibre.ui.pages.Navigate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.core.ui.WebDriverManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NavigateSteps {
    private Logger log = LogManager.getLogger(NavigateSteps.class);
    private Navigate navigate;

    public NavigateSteps(WebDriverManager webDriverManager) {
        navigate = new Navigate(webDriverManager);
    }

    @Given("Navegar a la pagina principal de Mercado Libre {string}")
    public void navegarALaPaginaPrincipalDeMercadoLibre(String url) {
        navigate.to(url);
    }
}
