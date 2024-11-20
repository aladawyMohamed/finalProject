package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;


public class D02_loginStepDef {

    P02_login login= new P02_login();


    @Given("user go to login page")
    public void goLoginPage() {
        login.loginLink().click();
    }

    @When("user login with {string} {string} and {string}")
    public void entreUserNameAndPassword(String type, String userName, String password) {
        System.out.println(type);
        login.emailBox().sendKeys(userName);
        login.passWordBox().sendKeys(password);
    }

    @And("user press on login button")
    public void pressLogin() {
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void successfullyLogin() {

        SoftAssert successAssert= new SoftAssert();


        String currentUrl = Hooks.driver.getCurrentUrl();
        successAssert.assertEquals(currentUrl, "https://demo.nopcommerce.com/", "login was unsuccessfully" );

        successAssert.assertTrue(login.myAccountTab().isDisplayed());

        successAssert.assertAll();
    }


    @Then("user could not login to the system")
    public void unsuccessfullyLoginMessage() {

        SoftAssert errorAssert=new SoftAssert();

        String errorMessage= login.errorMessage().getText();
        errorAssert.assertTrue(errorMessage.contains("Login was unsuccessful."), "The error message does not contain the expected text.");


        String messageColor = login.errorMessage().getCssValue("color");
        String messageColorInHex = Color.fromString(messageColor).asHex();
        String expectedColor = "#e4434b";
        errorAssert.assertEquals(messageColorInHex, expectedColor, "The color of the error message is not red.");


        errorAssert.assertAll();

    }

}
