package com.devsu.certification.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderCompleted {

    public static final Target MESSAGE_COMPLETATION_ORDER = Target.the("Message Order Completed").located(By.className("complete-header"));
}
