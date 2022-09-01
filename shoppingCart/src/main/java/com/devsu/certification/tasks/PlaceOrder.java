package com.devsu.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.devsu.certification.userInterfaces.Home.*;

public class PlaceOrder implements Task {

    private String prodOne;
    private String prodTwo;

    public PlaceOrder(String prodOne, String prodTwo) {
        this.prodOne = prodOne;
        this.prodTwo = prodTwo;
    }

    public static PlaceOrderBuilder of(String prodOne) {
        return new PlaceOrderBuilder(prodOne);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(prodButtonOpt(prodOne)),
                Click.on(prodButtonOpt(prodTwo)),
                Click.on(SHOPING_CART)
        );

    }
}
