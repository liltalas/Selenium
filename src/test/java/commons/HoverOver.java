package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverOver extends CommonMethods {

    @Test
    public void practiceHover() throws InterruptedException {
        WebDriver driver = getDriver();

        Actions actions = new Actions(driver);

        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        WebElement firstItem = driver.findElement(By.xpath("//li[@class='product-item'][1]"));

        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].scrollIntoView({block:'center', inline: 'nearest'})", firstItem);


        //moveToElement() method automatically scrolls down and hover over to an element
        // so to add scrollToElement() method is optional
        actions.scrollToElement(firstItem).moveToElement(firstItem).build().perform();

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://magento.softwaretestingboard.com/");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
