package org.example.StepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D01_registerStepDef {


    P01_register register= new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {
        register.registerlink().click();
    }

    @When("user select gender type")
    public void  selectGender(){
        register.genderField().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void enterFirstAndLastName(String fName, String lName){
        register.firstNameBox().sendKeys(fName);
        register.lastNameBox().sendKeys(lName);
    }

    @And ("user enter date of birth")
    public void enterBirthDate(){

        Select DayDropdown =new Select(register.birthDayList());
        Select MonthDropdown =new Select(register.birthMonthList());
        Select YearDropdown =new Select(register.birthYearList());
        DayDropdown.selectByValue("28");
        MonthDropdown.selectByValue("3");
        YearDropdown.selectByValue("1996");

    }

    @And("user enter email {string} field")
    public void enterEmail(String email){
        register.eMailBox().sendKeys(email);
    }

    @And ("user fills Password fields {string} {string}")
    public void enterPassword(String pass, String confirm){
        register.passwordBox().sendKeys(pass);
        register.confirmBox().sendKeys(confirm);
    }

    @And ("user clicks on register button")
    public void clickRegister(){
        register.registerBtn().click();
    }

    @Then("success message is displayed")
    public void successMessage(){

        WebElement actualMessage = register.resultMessage();
        Assert.assertTrue(actualMessage.isDisplayed(), "Success message is not displayed on the page.");

        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage.getText(), expectedMessage, "Success message is not displayed.");

        String messageColor = register.resultMessage().getCssValue("color");
        String expectedColor = "rgba(76, 177, 124, 1)";
        Assert.assertEquals(messageColor, expectedColor, "The color of the element is not green.");

    }
}
