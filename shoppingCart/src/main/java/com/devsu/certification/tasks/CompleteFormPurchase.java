package com.devsu.certification.tasks;

import com.devsu.certification.models.DeliveryData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static com.devsu.certification.userInterfaces.FormPurchase.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteFormPurchase implements Task {

    private DeliveryData deliveryData;

    public CompleteFormPurchase(DeliveryData deliveryData) {
        this.deliveryData = deliveryData;
    }

    public static Performable with(DeliveryData deliveryData) {
        return instrumented(CompleteFormPurchase.class, deliveryData);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(deliveryData.getFirstName()).into(FIRST_NAME_FIELD),
                Enter.theValue(deliveryData.getLastName()).into(LAST_NAME_FIELD),
                Enter.theValue(deliveryData.getZip()).into(ZIP_FIELD)
        );
    }
}
