package com.devsu.certification.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartList {

    public static final Target CART_LIST = Target.the("Cart List").located(By.className("inventory_item_name"));



}
