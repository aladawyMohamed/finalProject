package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P04_resultPage {

    public List<WebElement> nextPageButton()
    {return Hooks.driver.findElements(By.className("next-page"));}


    public List<WebElement> resultOnCurrentPage()
    {return Hooks.driver.findElements(By.className("product-title"));}


    public List<WebElement> nameResultProducts() {
        List<WebElement> allResults=new ArrayList<>();

        while (true) {
            allResults.addAll(resultOnCurrentPage());

                if (nextPageButton().size() > 0) {
                    nextPageButton().get(0).click();
                    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-title")));
                }else {break;}
        }
        return allResults;
    }



    public WebElement productNumberField()
    {return Hooks.driver.findElement(By.cssSelector(".sku .value"));}




    public List<WebElement> skuResultProducts() {
        List<WebElement> allSkuResults=new ArrayList<>();

        while (true) {

            for (int i = 0; i < resultOnCurrentPage().size(); i++) {
                resultOnCurrentPage().get(i).click();
                allSkuResults.add(productNumberField());
                Hooks.driver.navigate().back();}

            if (nextPageButton().size() > 0) {
                nextPageButton().get(0).click();
                WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-title")));
            }else {break;}
        }
        return allSkuResults;
    }





}
