package com.devsu.certification.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home {

    public static String PRODUCT = "add-to-cart-sauce-labs-%s";

    public static final Target SHOPING_CART = Target.the("Shoping Cart").located(By.className("shopping_cart_badge"));


    public static Target prodButtonOpt(String product){
        return Target.the("Producto").located(By.id(String.format(PRODUCT,product)));
    }






}
