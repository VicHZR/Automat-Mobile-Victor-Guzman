Feature: Gestión de compras en MydemoApp

  @CompraCarrito
  Scenario: Ingreso a la App y selección de productos
    Given ingreso al aplicativo de MydemoApp
    And valido que carguen correctamente los productos en la galería
    When agrego los siguientes productos al carrito de compras
      | PRODUCTO                 | UNIDADES |
      | Sauce Labs Backpack      | 2        |
      | Sauce Labs Fleece Jacket | 2        |
      | Sauce Labs Onesie        | 1        |
    And valido que los productos y sus unidades hayan sido agregados correctamente
