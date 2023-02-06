package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtils;

public class AdvancedMouseInteractions extends DriverUtils {

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException {
        WebDriver driver = getDriver();

        //Creating object of the actions class and passing webDriver as a particular to its constructor
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(), 'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(), 'Right')]"));

       // actions.doubleClick(doubleClickBtn).build().perform();



        actions.contextClick(rightClickBtn).build().perform();

        Thread.sleep(3000);

        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
        Thread.sleep(4000);
    }
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/buttons");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
