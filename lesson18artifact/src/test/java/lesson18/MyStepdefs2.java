package lesson18;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class MyStepdefs2 {
    private By userNameField = By.xpath("//input[@id='userName']");
    private By submitButton = By.xpath("//button[@id='submit']");
    private By submitString = By.xpath("//p[@id='name']");


    @Given("on the page {string} we have registration form")
    public void onThePageWeHaveRegistrationForm(String formpage) {
        lesson18.Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        lesson18.Hooks.driver.get(formpage);
    }

    @When("we enter {string}")
    public void weEnter(String userName) {
        lesson18.Hooks.driver.findElement(userNameField).sendKeys(userName);
        lesson18.Hooks.driver.findElement(submitButton).click();
    }



    @Then("submitted {string} is present on the page")
    public void submittedIsPresentOnThePage(String userName) {
        Assertions.assertEquals("Name:"+userName,lesson18.Hooks.driver.findElement(submitString).getText());
    }
}
