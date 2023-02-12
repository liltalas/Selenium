package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts extends CommonMethods {
    @Test
    public void learnAlertHandling() throws InterruptedException {
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement button1 = driver.findElement(By.id("alertButton"));
        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        WebElement button3 = driver.findElement(By.id("confirmButton"));
        WebElement button4 = driver.findElement(By.id("promtButton"));

        button1.click();

        // Alert interface has a coule of methods in order to handle alerts
        // switchTo().alert(); will switch to the presently active alert
        // We are creating an instance of the interface by switch to the current alert on the page
        driverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());

        // dismisses or closes the alert and switches back to the main frame
        alert.dismiss();

        button2.click();
        // here we r using explicit wait to wait for the alert to show up before continuing
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.dismiss();

        button3.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());

        // The same alert.accept() method is the same as clicking "OK" or confirming the alert
       // alert.accept();

        // the same as click "Cancel" or declining the alert
        alert.dismiss();
        WebElement selectionResult = driver.findElement(By.cssSelector("#confirmResult"));
       Assert.assertTrue("User did not select 'Cancel'", selectionResult.getText().equalsIgnoreCase("You Selected Cancel"));


        button4.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert=driver.switchTo().alert();
        Thread.sleep(3000);
        // types the string we pass to it into the input of the alert
        alert.sendKeys("Hello World!");
        Thread.sleep(3000);
        alert.accept();
        WebElement verifyTextMessage = driver.findElement(By.cssSelector("#promptResult"));
        Assert.assertTrue("The text does NOT match", verifyTextMessage.getText().equalsIgnoreCase("You entered Hello World!"));

        // We can create an alert by using WebDriverWait because the ExpectedConditions.alertIsPresent() method will return
        // driver.switchTo().alert()
        // killing 2 birds with 1 stone by both explicitly waiting for the alert to show up and switching
        // to it once it's available
        //Alert alert1 =  driverWait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/alerts");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
