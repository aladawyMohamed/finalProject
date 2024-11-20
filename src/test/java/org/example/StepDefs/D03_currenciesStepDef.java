package org.example.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D03_currenciesStepDef {

    P03_homePage homePage=new P03_homePage();


    @Given("user is on the home page")
    public void goHomePage() {
        String homePageUrl=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl, "https://demo.nopcommerce.com/");

    }

    @When("user select {string} currency from the currency dropdown list")
    public void selectEuro(String selectedCurrency) {
        Select currency=new Select(homePage.currencyList());
        currency.selectByVisibleText(selectedCurrency);
    }



    @Then("currency Symbol {string} is shown on the 4 products displayed in Home page")
    public void assertCurrency(String currencySymbol) {

        Assert.assertEquals(homePage.productPrices().size(), 4);

        for (int i = 0; i < 4; i++) {
            String priceText = homePage.productPrices().get(i).getText();
            Assert.assertTrue(priceText.contains(currencySymbol), "The price text does not contain the Euro symbol");
        }



    }


}
