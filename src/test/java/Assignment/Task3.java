package Assignment;

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

public class Task3 extends DriverUtils {

    // 1. Open https://www.timeanddate.com/timer/
    @Before
    public void setUp(){
        createDriver("https://www.timeanddate.com/timer/");

    }

    @Test
    public void resetOnlineTimer() throws InterruptedException {
        WebDriver driver = getDriver();

        //2. Find locators for the start and reset button
        WebElement startButton = driver.findElement(By.xpath("//button[@title='Start timer']"));
        WebElement resetButton = driver.findElement(By.xpath("//button[@title='Reset and start over']"));

        //3. Press start button and explicitly wait until time hits 00:01:45 then press the pause button
        startButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement timeLeft = driver.findElement(By.xpath("//span[@class='timeLeft']"));

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(timeLeft,"00:01:45"));

        startButton.click();

        Thread.sleep(3000);

        // 4. Assert that the time is indeed 00:01:45 then click reset button and assert that time was reset

        Assert.assertTrue("The timer is NOT indeed 00:01:45", timeLeft.isDisplayed());
        System.out.println(timeLeft.getText());

        resetButton.click();

        Thread.sleep(3000);

        Assert.assertTrue("The timer has not been reset to 00:02:00", timeLeft.isDisplayed());

        System.out.println(timeLeft.getText());

        Thread.sleep(3000);

    }



    @After
    public void cleanUp(){
        quitDriver();
    }
}
