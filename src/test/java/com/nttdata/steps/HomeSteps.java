package com.nttdata.steps;

import com.nttdata.screens.HomeScreen;
import org.jruby.RubyProcess;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class HomeSteps {

    HomeScreen homeScreen;

    public void validoGaleriaProductos() {
        String tituloActual = homeScreen.getTitle(20);
        Assert.assertEquals("Products", tituloActual);
    }

    public void agregarProductoAlCarrito(String nombreProducto, int unidades) throws IOException, InterruptedException {
        homeScreen.clickProducto(nombreProducto);
        homeScreen.agregarUnidades(unidades);
        homeScreen.volverAlCatalgo();
        homeScreen.getTitle(20);
    }

    public void validarProductosYUnidadesEnCarrito(Map<String, Integer> diccionarioProductosUnidades) throws IOException, InterruptedException {
        homeScreen.clickCarrito();

        for (Map.Entry<String, Integer> entry : diccionarioProductosUnidades.entrySet()) {
            String producto = entry.getKey();
            Integer unidades = Integer.parseInt(String.valueOf(entry.getValue()));
            System.out.println("Producto del diccionario: " + producto);
            System.out.println("Unidades del diccionario: " + unidades);

            homeScreen.validarProductoYUnidades(producto, unidades);
        }
    }

}
