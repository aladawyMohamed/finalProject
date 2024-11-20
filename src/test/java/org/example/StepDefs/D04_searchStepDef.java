package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P04_resultPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage homePage=new P03_homePage();
    P04_resultPage resultPage=new P04_resultPage();

    @When("user enter {string} on the searchBox")
    public void enterSearch(String searchText) {
        homePage.searchBox().sendKeys(searchText);
    }


    @And("user clicks on search button")
    public void clickSearch() {
        homePage.searchButton().click();
    }


    @Then("results are displayed for product name {string}")
    public void resultsName(String searchText) {
        SoftAssert nameAssert= new SoftAssert();

        String currentUrl = Hooks.driver.getCurrentUrl();
        nameAssert.assertTrue(currentUrl.contains("https://demo.nopcommerce.com/search?q="), "search was unsuccessful");


        for (int i = 0; i < resultPage.nameResultProducts().size(); i++) {
            String productTitle = resultPage.nameResultProducts().get(i).getText().toLowerCase();
            nameAssert.assertTrue(productTitle.contains(searchText.toLowerCase()));
        }

        nameAssert.assertAll();
    }


    @Then("results are displayed for product sku {string}")
    public void resultsSku(String productNumber) {



        for (int i = 0; i < resultPage.skuResultProducts().size(); i++) {
            String skuText = resultPage.skuResultProducts().get(i).getText();
            Assert.assertTrue(skuText.contains(productNumber));
        }


    }
}
