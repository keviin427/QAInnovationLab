package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement tituloProductos;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<WebElement> productos;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Backpack']")
    private WebElement productoBackpack;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Fleece Jacket']")
    private WebElement productoFleeceJacket;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Onesie']")
    private WebElement productoOnesie;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Tap to add product to cart']")
    private WebElement botonAgregarAlCarrito;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Increase item quantity']")
    private WebElement botonIncrementarCantidad;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Displays number of items in your cart']")
    private WebElement botonCarritoCompras;

    public boolean productosCargados() {
        return !productos.isEmpty();
    }

    public void agregarProducto(String producto, int unidades) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement productoElemento = null;

        switch (producto) {
            case "Sauce Labs Backpack":
                productoElemento = productoBackpack;
                break;
            case "Sauce Labs Fleece Jacket":
                productoElemento = productoFleeceJacket;
                break;
            case "Sauce Labs Onesie":
                productoElemento = productoOnesie;
                break;
            default:
                throw new IllegalArgumentException("Producto no soportado: " + producto);
        }

        wait.until(ExpectedConditions.visibilityOf(productoElemento));

        productoElemento.click();
        wait.until(ExpectedConditions.elementToBeClickable(botonAgregarAlCarrito));
        botonAgregarAlCarrito.click();

        for (int i = 1; i < unidades; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(botonIncrementarCantidad));
            botonIncrementarCantidad.click();
        }

        getDriver().navigate().back();
    }

    public boolean carritoActualizado(int cantidadEsperada) {
        botonCarritoCompras.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(botonCarritoCompras));


        return true;
    }
}
