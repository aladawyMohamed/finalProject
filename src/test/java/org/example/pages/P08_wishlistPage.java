package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P08_wishlistPage {
    public WebElement quantityField()
    {return Hooks.driver.findElement(By.className("qty-input"));}
}
