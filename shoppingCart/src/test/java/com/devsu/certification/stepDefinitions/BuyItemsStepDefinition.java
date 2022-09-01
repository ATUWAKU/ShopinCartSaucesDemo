package com.devsu.certification.stepDefinitions;

import com.devsu.certification.models.DeliveryData;
import com.devsu.certification.models.LoginData;
import com.devsu.certification.models.PurchaseData;
import com.devsu.certification.tasks.Authenticate;
import com.devsu.certification.tasks.Makepurchases;
import com.devsu.certification.tasks.Navigate;
import com.devsu.certification.tasks.PlaceOrder;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.devsu.certification.userInterfaces.CartList.*;
import static com.devsu.certification.userInterfaces.OrderCompleted.MESSAGE_COMPLETATION_ORDER;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class BuyItemsStepDefinition {

    private static final String YISUS = "Yisus";

    @DataTableType
    public LoginData convert(Map<String, String> object){
        LoginData obj = new LoginData();

        obj.setUser(object.get("User"));
        obj.setPassword(object.get("Password"));
        return obj;
    }

    @DataTableType
    public PurchaseData conv(Map<String, String> object){
        PurchaseData obj = new PurchaseData();
        DeliveryData objDel = new DeliveryData();
        obj.setProducts(Arrays.asList(object.get("ProductOne"), object.get("ProductTwo")));
        objDel.setFirstName(object.get("FirstName"));
        objDel.setLastName(object.get("LastName"));
        objDel.setZip(object.get("Zip"));
        obj.setDeliveryData(objDel);
        return obj;
    }


    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @Given("I authenticate with User And Password")
    public void iAuthenticateWithUserAndPassword(LoginData loginData) {
        theActorCalled(YISUS).wasAbleTo(
                Navigate.LoginPage(),
                Authenticate.with(loginData));
    }
    @When("I make the order of {string} and {string}")
    public void iMakeTheOrderOfAnd(String prodOne, String prodTwo) {
        theActorInTheSpotlight().attemptsTo(
                PlaceOrder.of(prodOne).and(prodTwo).viewOrder()
        );
    }
    @Then("The purchase order must list the products {string} and {string}")
    public void thePurchaseOrderMustListTheProducts(String prodOne, String prodTwo) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CART_LIST).textValues().contains(prodOne),
                Ensure.that(CART_LIST).textValues().contains(prodTwo)
        );
    }

    @When("I make the purchase of ProductOne and ProductTwo for FirstName LastName to Zip")
    public void iMakeThePurchaseOfAnd(PurchaseData purchaseData) {
        theActorInTheSpotlight().attemptsTo(
                Makepurchases.with(purchaseData)
        );
    }
    @Then("The purchase must be completed by displaying the message {string}")
    public void thePurchaseMustBeCompletedByDisplayingTheMessage(String outputMessage) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE_COMPLETATION_ORDER).textValues().contains(outputMessage)
        );
    }
}
