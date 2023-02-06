package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public class BrowserSynchronization extends DriverUtils {
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/progress-bar");

    }

    @Test
    public void learnWaits() throws InterruptedException {
        WebDriver driver = getDriver();
        //Creating an object of WebDriverWait class and passing the driver (to access current driver session) and
        // the duration of seconds we want to wait for the expected conditions to be true
        // explicit way - what condition we wait for
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // We can this element by:
        // xpath // //button[@id='startStopButton']
        // id startStopButton
        // css #startStopButton


        WebElement startButton = driver.findElement(By.xpath("//button[@id='startStopButton']"));
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));
        startButton.click();

        String expectedValue = "100%";

        // Using our driverWait variable to call until method to wait for textToBePresentInElement() condition to return true
        // Not: if the condition is true before the time is up it will not wait for the full time
        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));

        Assert.assertTrue("Value does not math as expected " + expectedValue, progressBar.getText().contains("100%"));

        Thread.sleep(5000);
        System.out.println(progressBar.getText());
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
