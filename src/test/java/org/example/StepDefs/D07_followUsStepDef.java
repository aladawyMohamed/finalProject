package org.example.StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class D07_followUsStepDef {

    P03_homePage homePage=new P03_homePage();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @When("user opens facebook link")
    public void openFacebook() {
        homePage.faceBookIcon().click();
    }
    @When("user opens twitter link")
    public void openTwitter() {
        homePage.twitterIcon().click();
    }
    @When("user opens rss link")
    public void openRss() {
        homePage.rssIcon().click();
    }
    @When("user opens youtube link")
    public void openYoutube() {
        homePage.youtubeIcon().click();
    }


    @Then("{string} is opened in new tab")
    public void linkOpened(String expectedUrl) {

        List<String> allTabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(allTabs.get(1));

        wait.until(ExpectedConditions.urlContains(expectedUrl));
        Assert.assertEquals(expectedUrl, Hooks.driver.getCurrentUrl(), "expacted link is not opened");
        System.out.println("link is opened successfully");
        Hooks.driver.close();
    }

}
