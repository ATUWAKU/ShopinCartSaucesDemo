package com.devsu.certification.tasks;

import com.devsu.certification.models.LoginData;
import jxl.demo.Write;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;


import static com.devsu.certification.userInterfaces.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Authenticate implements Task {

    private LoginData loginData;

    public Authenticate(LoginData loginData) {
        this.loginData = loginData;
    }

    public static Performable with(LoginData loginData) {
        return instrumented(Authenticate.class, loginData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(loginData.getUser()).into(USER_FIELD),
                Enter.theValue(loginData.getPassword()).into(PASSWORD_FIELD),
                Click.on(Button.withText("LOGIN"))
        );

    }
}
