package lesson18;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Hooks
{
    protected static WebDriver driver;

    @Before
    public void beforeScenario(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("This will run before the Scenario");
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        driver.quit();
    }
}
