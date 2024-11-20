package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginLink()
    {return Hooks.driver.findElement(By.className("ico-login"));}

    public WebElement emailBox()
    {return Hooks.driver.findElement(By.id("Email"));}

    public WebElement passWordBox()
    {return Hooks.driver.findElement(By.id("Password"));}

    public WebElement loginBtn()
    {return Hooks.driver.findElement(By.className("login-button"));}

    public WebElement myAccountTab()
    {return Hooks.driver.findElement(By.className("ico-account"));}

    public WebElement errorMessage()
    {return Hooks.driver.findElement(By.className("message-error"));}



}
