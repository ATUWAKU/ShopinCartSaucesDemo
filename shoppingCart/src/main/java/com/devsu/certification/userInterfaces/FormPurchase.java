package com.devsu.certification.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormPurchase {

    public static final Target FIRST_NAME_FIELD = Target.the("First Name Delivery").located(By.id("first-name"));
    public static final Target LAST_NAME_FIELD = Target.the("Last Name Delivery").located(By.id("last-name"));
    public static final Target ZIP_FIELD = Target.the("Postal Code").located(By.id("postal-code"));
}
