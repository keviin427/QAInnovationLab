package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductStepsDef {

    @Steps
    ProductSteps productSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        productSteps.abrirAplicacion();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        productSteps.validarProductosEnGaleria();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoProducto(int unidades, String producto) {
        productSteps.agregarProducto(producto, unidades);
    }

    @Then("valido el carrito de compra actualice correctamente con {int} productos")
    public void validoElCarritoDeCompraActualiceCorrectamente(int cantidadEsperada) {
        productSteps.validarCarrito(cantidadEsperada);
    }
}
