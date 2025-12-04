package com.mercadolibre.ui.steps;

import com.core.ui.WebDriverManager;
import com.mercadolibre.ui.pages.common.BarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonUISteps {
    private BarPage barPage;

    public CommonUISteps(WebDriverManager webDriverManager) {
        barPage = new BarPage(webDriverManager);
    }

    @When("Escribir {string} en el campo de busqueda")
    public void escribirEnElCampoDeBusqueda(String value) {
        barPage.typeSearchTextBox(value);
    }

    @And("Click en el boton de busqueda")
    public void clickEnElBotonDeBusqueda() {
        barPage.clickSearchButton();
    }
}
