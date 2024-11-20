package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {

    public WebElement currencyList()
    {return Hooks.driver.findElement(By.id("customerCurrency"));}

    public List<WebElement> productPrices()
    {return Hooks.driver.findElements(By.className("actual-price"));}

    public WebElement searchBox()
    {return Hooks.driver.findElement(By.id("small-searchterms"));}

    public WebElement searchButton()
    {return Hooks.driver.findElement(By.className("search-box-button"));}

    public List<WebElement> mainCategories()
    {return Hooks.driver.findElements(By.cssSelector(".top-menu.notmobile > li"));}

    public WebElement firstSlider()
    {return Hooks.driver.findElement(By.cssSelector("#nivo-slider a:nth-child(1)"));}

    public WebElement secondSlider()
    {return Hooks.driver.findElement(By.cssSelector("#nivo-slider a:nth-child(2)"));}

    public WebElement faceBookIcon()
    {return Hooks.driver.findElement(By.className("facebook"));}

    public WebElement twitterIcon()
    {return Hooks.driver.findElement(By.className("twitter"));}

    public WebElement rssIcon()
    {return Hooks.driver.findElement(By.className("rss"));}

    public WebElement youtubeIcon()
    {return Hooks.driver.findElement(By.className("youtube"));}

    public WebElement wishListButtonForHTC()
    {return Hooks.driver.findElement(By.xpath("//div[@data-productid='18']//button[@class='button-2 add-to-wishlist-button']"));}

    public WebElement successMessage()
    {return Hooks.driver.findElement(By.className("bar-notification"));}

    public WebElement wishListTab()
    {return Hooks.driver.findElement(By.className("wishlist-label"));}



}
