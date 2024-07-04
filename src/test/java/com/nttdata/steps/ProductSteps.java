package com.nttdata.steps;

import com.nttdata.screens.ProductScreen;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductSteps {

    ProductScreen productScreen;

    @Step("Abrir la aplicación")
    public void abrirAplicacion() {
        // Implementar la lógica para abrir la aplicación, si es necesario
    }

    @Step("Validar productos en galeria")
    public void validarProductosEnGaleria() {
        Assert.assertTrue("Los productos no cargaron correctamente", productScreen.productosCargados());
    }

    @Step("Agregar producto {0} con {1} unidades")
    public void agregarProducto(String producto, int unidades) {
        productScreen.agregarProducto(producto, unidades);
    }

    @Step("Validar carrito de compras")
    public void validarCarrito(int cantidadEsperada) {
        Assert.assertTrue("El carrito no se actualizó correctamente", productScreen.carritoActualizado(cantidadEsperada));
    }
}

