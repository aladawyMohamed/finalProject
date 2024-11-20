package org.example.StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    P03_homePage homePage=new P03_homePage();


    @When("user clicks on the slider {string}")
    public void clickSlider(String sliderNumber) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nivo-slider")));

        if (sliderNumber.equals("first")){
            homePage.firstSlider().click();}
        else if (sliderNumber.equals("second")) {
            homePage.secondSlider().click();}

    }


    @Then("product page {string} is opened")
    public void productOpened(String urlProduct) {

        wait.until(ExpectedConditions.urlContains(urlProduct));

        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(urlProduct), "Slider did not redirect to the correct URL.");
        System.out.println("Slider redirected correctly.");
    }
}
