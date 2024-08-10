package com.nttdata.stepsdefinitions;

import com.nttdata.steps.HomeSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeStepdefs {
    @Steps
    HomeSteps homeSteps;

    Map<String, Integer> diccionarioProductosUnidades = new HashMap<>();


    @Given("ingreso al aplicativo de MydemoApp")
    public void ingresoAlAplicativoDeMydemoApp() {
        System.out.println("Abro la aplicacion MydemoApp");
    }

    @And("valido que carguen correctamente los productos en la galería")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGalería() {
        homeSteps.validoGaleriaProductos();
        System.out.println("Valide que cargaron los productos en la galeria");
    }

    @When("agrego los siguientes productos al carrito de compras")
    public void agregoLosSiguientesProductosAlCarritoDeCompras(DataTable tablaProductos) throws IOException, InterruptedException {
        List<Map<String, String>> productos = tablaProductos.asMaps();
        System.out.println(productos);
        for (Map<String, String> producto : productos) {
            String nombreProducto = producto.get("PRODUCTO");
            int unidades = Integer.parseInt(producto.get("UNIDADES"));
            System.out.println("Producto: " + nombreProducto);
            System.out.println("Unidades: " + unidades);
            diccionarioProductosUnidades.put(nombreProducto, unidades);
            homeSteps.agregarProductoAlCarrito(nombreProducto, unidades);
        }
    }

    @And("valido que los productos y sus unidades hayan sido agregados correctamente")
    public void validoQueLosProductosYSusUnidadesHayanSidoAgregadosCorrectamente() throws IOException, InterruptedException {
        homeSteps.validarProductosYUnidadesEnCarrito(diccionarioProductosUnidades);

    }
}
