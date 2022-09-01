package com.devsu.certification.tasks;

import com.devsu.certification.models.DeliveryData;
import com.devsu.certification.models.PurchaseData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Makepurchases implements Task {

    private String prodOne;
    private String prodTwo;
    DeliveryData deliveryData;

    public Makepurchases(PurchaseData purchaseData) {
        this.prodOne = purchaseData.getProducts().get(0);
        this.prodTwo = purchaseData.getProducts().get(1);
        this.deliveryData = purchaseData.getDeliveryData();
    }

    public static Performable with(PurchaseData purchaseData) {
        return instrumented(Makepurchases.class,purchaseData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PlaceOrder.of(prodOne).and(prodTwo).viewOrder(),
                Click.on(Button.withText("CHECKOUT")),
                CompleteFormPurchase.with(deliveryData),
                Click.on(Button.withText("CONTINUE")),
                Click.on(Button.withText("FINISH"))
        );

    }
}
