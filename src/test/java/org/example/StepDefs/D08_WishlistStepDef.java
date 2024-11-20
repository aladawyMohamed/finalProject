package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P08_wishlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {

    P03_homePage homePage=new P03_homePage();
    P08_wishlistPage wishlistPage=new P08_wishlistPage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @When("user clicks on wishlist button on the product")
    public void clickWishlistButton() {
        homePage.wishListButtonForHTC().click();
    }


    @Then("the success message {string} is displayed")
    public void successMessage(String successMessageText) {
        SoftAssert assertMessage=new SoftAssert();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

        assertMessage.assertTrue(homePage.successMessage().isDisplayed(), "The message is not displayed");
        assertMessage.assertEquals(homePage.successMessage().getText(), successMessageText, "The message text is incorrect");
        assertMessage.assertEquals(homePage.successMessage().getCssValue("background-color"), "rgba(0, 128, 0, 1)", "The background color is not green");
    }


    @And("user go to the wishlist page")
    public void goWishlistPage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("bar-notification")));
        homePage.wishListTab().click();
    }


    @Then("the wishlist should contains the added product")
    public void addedProduct() {
        SoftAssert assertQuantity=new SoftAssert();
        int quantityInput= Integer.parseInt(wishlistPage.quantityField().getAttribute("value"));
        assertQuantity.assertTrue(quantityInput>0, "The quantity value is not greater than 0");
    }
    
}
