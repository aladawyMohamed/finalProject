package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {

    P03_homePage homePage=new P03_homePage();
    WebElement selectedCategory;
    List <WebElement> subCategories;
    WebElement selectedSubCategory;



    @When("user hover on one random category of the main categories")
    public void hoverMainCategory() {
        Random random=new Random();
        selectedCategory = homePage.mainCategories().get(random.nextInt(homePage.mainCategories().size()));

        Actions hover=new Actions(Hooks.driver);
        hover.moveToElement(selectedCategory).perform();
    }





    @And("user select random sub category")
    public void selectSubCategory() {
        subCategories= selectedCategory.findElements(By.cssSelector(".sublist.first-level > li > a"));


        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if (!subCategories.isEmpty()) {
            Random random = new Random();
            selectedSubCategory = subCategories.get(random.nextInt(subCategories.size()));
            System.out.println("Selected sub-category: " + selectedSubCategory.getText());
            selectedSubCategory.click();

        } else {
            System.out.println("Selected main-category: " + selectedCategory.getText());
            selectedCategory.click();
        }
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }





    @Then("sub category page is opened")
    public void subCategoryOpened() {
        String pageTitle = Hooks.driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText().toLowerCase().trim();

        if (!subCategories.isEmpty()) {
            Assert.assertTrue(pageTitle.contains(selectedSubCategory.getText().toLowerCase().trim()), "page title doesn't contain sub category title");

        } else {Assert.assertTrue(pageTitle.contains(selectedCategory.getText().toLowerCase().trim()), "page title doesn't contain main category title ");}
    }



}
