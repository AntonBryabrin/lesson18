package lesson18;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {

    private By searchInput = By.xpath("//input[@class='input__control input__input mini-suggest__input']");
    private By searchButton = By.xpath("//tbody/tr[2]/td[1]/form[1]/div[2]/button[1]");
    private By firstResult = By.xpath("(//div[@class='OrganicTitle-LinkText organic__url-text'])[1]");





    @Given("In system {string} we have results for request {string}")
    public void inSystemWeHaveResultsForRequest(String searchSystem, String request) {

        System.out.println("Will search "+ request + " in " + searchSystem);
    }

    @When("Search in {string} by request {string}")
    public void searchInByRequest(String searchSystem, String request) throws InterruptedException{

        lesson18.Hooks.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        lesson18.Hooks.driver.get(searchSystem);
        lesson18.Hooks.driver.findElement(searchInput).click();
        lesson18.Hooks.driver.findElement(searchInput).sendKeys(request);
        lesson18.Hooks.driver.findElement(searchButton).click();

    }

    @Then("Result with request {string} is presented on the page")
    public void resultWithRequestIsPresentedOnThePage(String request) {

        Assertions.assertEquals(request,lesson18.Hooks.driver.findElement(firstResult).getText());


    }




}
