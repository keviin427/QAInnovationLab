@ProductTest
Feature: Validar funcionalidad del carrito de compras en SauceLabs

  Scenario: Agregar productos al carrito de compras
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente
