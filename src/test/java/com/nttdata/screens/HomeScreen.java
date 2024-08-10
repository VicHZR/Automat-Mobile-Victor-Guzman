package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.bytebuddy.implementation.bytecode.Throw;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class HomeScreen extends PageObject {
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")
    private WebElement quantityProducts;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Increase item quantity']")
    private WebElement masProductos;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement btnAddToCart;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private WebElement btnOpciones;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Catalog']")
    private WebElement btnCatalog;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement btnCarrito;


    public String getTitle(int timeout) {
        String idTitle = "com.saucelabs.mydemoapp.android:id/productTV";


        WebDriverWait wait = new WebDriverWait(getDriver(), (long) timeout);

        // Esperar hasta que el elemento sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idTitle)));

        // Encontrar el elemento y devolver su texto
        return getDriver().findElement(By.id(idTitle)).getText();
    }

    public void clickProducto(String producto) throws IOException, InterruptedException {
        String xpath = "//*[contains(@text,'" + producto + "')]/..";
        System.out.println("xPath: " + xpath);
        boolean found = false;
        do {
            try {
                WebElement elemento = getDriver().findElement(By.xpath(xpath));
                elemento.click();
                System.out.println("Seleccioné el producto: " + producto);
                found = true;
            } catch (NoSuchElementException e) {
                System.out.println("No encontré el producto: " + producto);
                e.getMessage();
                scrollHaciaAbajo();
                Thread.sleep(1000);
            }
        } while (!found);

    }

    public void scrollHaciaAbajo() throws IOException {
        String comando = "adb shell input swipe 500 1500 500 1000 500";
        Runtime.getRuntime().exec(comando);
    }

    public void scrollHaciaArriba() throws IOException {
        String comando = "adb shell input swipe 500 500 500 1500 500";
        Runtime.getRuntime().exec(comando);
    }


    public void agregarUnidades(int unidades) {
        if (unidades == 1) {
            clickAddToCart();
            return;
        }
        while (unidades > getCantidadProductos()) {
            masProductos.click();
            if (unidades == getCantidadProductos()) {
                clickAddToCart();
                return;
            }
        }

    }

    public int getCantidadProductos() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")));
        return Integer.parseInt(quantityProducts.getText());
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        btnAddToCart.click();
    }

    public void volverAlCatalgo() {
        clickDesplegarOpciones();
        clickCatalog();
    }

    public void clickDesplegarOpciones() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnOpciones));
        btnOpciones.click();
    }

    public void clickCatalog() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnCatalog));
        btnCatalog.click();
    }

    public void clickCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnCarrito));
        btnCarrito.click();
    }

    public void validarProductoYUnidades(String producto, int unidades) throws IOException, InterruptedException {
        String xPathProducto = "//*[contains(@text,'" + producto + "')]";
        String xPathUnidades = "//*[contains(@text,'" + producto + "')]/../following-sibling::*/child::*[1]/child::*[2]";
        int count = 0;
        boolean productoEncontrado = false;

        do {
            try {
                getDriver().findElement(By.xpath(xPathProducto));
                System.out.println("Encontré el producto: " + producto);
                Assert.assertEquals(unidades, Integer.parseInt(getDriver().findElement(By.xpath(xPathUnidades)).getText()));
                System.out.println("Las unidades de " + producto + "han sido validadas");
                productoEncontrado = true;
            } catch (NoSuchElementException e) {
                e.getMessage();
                scrollHaciaAbajo();
                count += 1;
                Thread.sleep(1000);
            }
        } while (count < 10 && !productoEncontrado); // Añadido límite para evitar bucle infinito

        if (productoEncontrado) {
            for (int i = 0; i < count; i++) {
                scrollHaciaArriba();
            }
        } else {
            throw new RuntimeException("Producto " + producto + " no encontrado");
        }
    }


}
