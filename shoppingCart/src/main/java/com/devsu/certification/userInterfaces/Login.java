package com.devsu.certification.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login {

    public static final Target USER_FIELD = Target.the("User Name Login").located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("Password Login").located(By.id("password"));

}
