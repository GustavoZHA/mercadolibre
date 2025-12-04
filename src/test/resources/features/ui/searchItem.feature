@gui
Feature: Búsqueda de productos en Mercado Libre Bolivia

  Scenario Outline: Verficar que la búsqueda válida devuelve resultados
    Given Navegar a la pagina principal de Mercado Libre "Bolivia"
    When Escribir "<buscar>" en el campo de busqueda
    And Click en el boton de busqueda
    Then se debe mostrar la pagina de resultados de busqueda
    And verificar que cada producto debe mostrar imagen, Titulo y precio
    Examples:
      | buscar      |
      | celular     |
      | laptop      |
      | auriculares |

  Scenario Outline: Búsqueda que no devuelve resultados
    Given Navegar a la pagina principal de Mercado Libre "Bolivia"
    When Escribir "<buscar>" en el campo de busqueda
    And Click en el boton de busqueda
    Then Verificar que el "No hay publicaciones que coincidan con tu búsqueda." mensaje se desplega
    Examples:
      | buscar                 |
      | drogas                 |
      | mariguana              |
      | peliculas pornografica |
