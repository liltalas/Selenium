package practice;

import commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPractice extends CommonMethods {

    @Test
    public void frameAlert() throws InterruptedException {
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // switch to the frame1 from the main page
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));

        driver.switchTo().frame(frame1);
        Thread.sleep(3000);

        // select "-Alert" option from dropdown (which is inside the frame1)
        WebElement dropdown = driver.findElement(By.id("selectnav1"));
        Select dropOptions = new Select(dropdown);

        // this method explicitly waits until it finds the target text
        driverWait.until(ExpectedConditions.textToBePresentInElement(dropdown, "- Alerts"));
        dropOptions.selectByVisibleText("- Alerts");

        //the page has to reload since the program will have hard times to find the locator/perform some methods
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame1);

        // click the button "Click Me"

        WebElement alertClick = driver.findElement(By.xpath("//button[@id=\"alertBox\"]"));
        //alertClick.click();

       //div[@dir='ltr']/div[1]/button
        Thread.sleep(2000);

        // accept the alert(by clicking "OK") using

        Alert alert1 = driverWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        alert1.accept();

        Assert.assertTrue("Didn't Match", alert1.getText().equalsIgnoreCase("I am an alert box!"));
        Thread.sleep(3000);
    }


    @Before
    public void setUp(){
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
