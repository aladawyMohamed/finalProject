package org.example.pages;
//import com.automation.step_definitions.Hooks;
import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {
    public WebElement registerlink()
    {return Hooks.driver.findElement(By.className("ico-register")); }

    public WebElement genderField()
    {return Hooks.driver.findElement(By.id("gender-male"));  }

    public WebElement firstNameBox()
    { return Hooks.driver.findElement(By.id("FirstName"));}

    public WebElement lastNameBox()
    {return Hooks.driver.findElement(By.id("LastName"));}

    public WebElement birthDayList()
    {return Hooks.driver.findElement(By.name("DateOfBirthDay"));}

    public WebElement birthMonthList()
    {return Hooks.driver.findElement(By.name("DateOfBirthMonth"));}

    public WebElement birthYearList()
    {return Hooks.driver.findElement(By.name("DateOfBirthYear"));}

    public WebElement eMailBox()
    {return Hooks.driver.findElement(By.id("Email"));}

    public WebElement passwordBox()
    {return Hooks.driver.findElement(By.id("Password"));}

    public WebElement confirmBox()
    {return Hooks.driver.findElement(By.id("ConfirmPassword"));}

    public WebElement registerBtn()
    {return Hooks.driver.findElement(By.id("register-button"));}

    public WebElement resultMessage()
    {return Hooks.driver.findElement(By.className("result"));}


}
