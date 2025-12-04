package com.mercadolibre.ui.steps;

import com.core.ui.WebDriverManager;
import com.mercadolibre.ui.pages.search.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SearchPageSteps {
    private SearchPage searchPage;
    
    public SearchPageSteps(WebDriverManager webDriverManager) {
        searchPage = new SearchPage(webDriverManager);
    }


    @Then("se debe mostrar la pagina de resultados de busqueda")
    public void seDebeMostrarLaPaginaDeResultadosDeBusqueda() {
        Assert.assertTrue(searchPage.getNumberItemsResult()>0, "The search result is not displayed/working");
    }

    @And("verificar que cada producto debe mostrar imagen, Titulo y precio")
    public void verificarQueCadaProductoDebeMostrarImagenTituloYPrecio() {
        Assert.assertTrue(searchPage.getNumberImgResults()>0, "The imagen item result is not displayed/working");
        Assert.assertTrue(searchPage.getNumberDescriptionResult()>0, "The description item result is not displayed/working");
        Assert.assertTrue(searchPage.getNumberPriceResult()>0, "The price item result is not displayed/working");

    }

    @Then("Verificar que el {string} mensaje se desplega")
    public void verificarQueElMensajeSeDesplega(String expectedMessage) {
        Assert.assertEquals(searchPage.getResultNullText(), expectedMessage, "The message displayed is not correct");
    }
}
