package Assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.DriverUtils;

// Handling Iframes
public class Task8 extends DriverUtils {

    //1. Open the website
    @Before
    public void setUp(){
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @Test
    public void handlingIframes() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;

    //2. Scroll down so that the “Frame2:” is visible. This iFrame should be talking about “Basic Controls in HTML”

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frm2']"));
        actions.scrollToElement(frame2).build().perform();
        Thread.sleep(3000);

    // 3. Switch to the frame and fill out the form
        driver.switchTo().frame(frame2);

        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("selectnav1"));
        Select dropOptions = new Select(dropdown);
        dropOptions.selectByVisibleText("- Basic Controls");

        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Enter First Name']"));
        firstName.sendKeys("ABC");

        Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("OS");
        Thread.sleep(1000);


        // used js executor to scroll into view since actions interface methods could not solve the issue
        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline: 'nearest'})", gender);
        gender.click();
        Thread.sleep(3000);

        WebElement language = driver.findElement(By.xpath("//input[@id = 'englishchbx']"));
        language.click();
        Thread.sleep(3000);

        WebElement emailAddress = driver.findElement(By.id("email"));
        emailAddress.sendKeys("asman@gmail.com");
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Zbc12345");
        Thread.sleep(3000);

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
