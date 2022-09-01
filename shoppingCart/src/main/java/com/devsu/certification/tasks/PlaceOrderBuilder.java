package com.devsu.certification.tasks;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlaceOrderBuilder {
    private String prodOne;
    private String prodTwo;

    public PlaceOrderBuilder(String prodOne) {
        this.prodOne = prodOne;
    }

    public PlaceOrderBuilder and(String prodTwo) {
        this.prodTwo = prodTwo;
        return this;
    }

    public Performable viewOrder() {
        return instrumented(PlaceOrder.class, prodOne,prodTwo);
    }
}
