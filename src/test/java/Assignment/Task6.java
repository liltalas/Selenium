package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;
import java.util.List;

// This program's goal is to practice JS Executor and hover over
public class Task6 extends DriverUtils {

    // 1. Create a new class and open the website
    @Test
    public void practiceJSExecutorAndHover() throws InterruptedException {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actions actions = new Actions(driver);


    // 2. Scroll down and into view centered all the items in the “Hot Sellers” section
        WebElement hotSellersTitle = driver.findElement(By.xpath("//h2[text()='Hot Sellers']"));

        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(3000);

        // retrieving the Y coordinate of the hotSellersTitle WebElement on the page
        int yPositionOfHotSellers = hotSellersTitle.getLocation().getY();
        js.executeScript("window.scrollBy(0, " + yPositionOfHotSellers + ")");

        Thread.sleep(3000);




    // 3. Hover over each element one at a time and assert that the add to cart button is visible on each element.
        // Try using a loop to accomplish this.

        WebElement item1 = driver.findElement(By.xpath("//li[@class='product-item'][1]"));
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline: 'nearest'})", item1);

        actions.moveToElement(item1).build().perform();
        Thread.sleep(3000);

        WebElement item2 = driver.findElement(By.xpath("//li[@class='product-item'][2]"));
        actions.moveToElement(item2).build().perform();
        Thread.sleep(1000);

        WebElement item3 = driver.findElement(By.xpath("//li[@class='product-item'][3]"));
        actions.moveToElement(item3).build().perform();
        Thread.sleep(1000);

        WebElement item4 = driver.findElement(By.xpath("//li[@class='product-item'][4]"));
        actions.moveToElement(item4).build().perform();
        Thread.sleep(1000);

        WebElement item5 = driver.findElement(By.xpath("//li[@class='product-item'][5]"));
        actions.moveToElement(item5).build().perform();
        Thread.sleep(1000);

        WebElement item6 = driver.findElement(By.xpath("//li[@class='product-item'][6]"));
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline: 'nearest'})", item6);
        actions.moveToElement(item6).build().perform();
        Thread.sleep(1000);


        List<WebElement> allProductItems = driver.findElements(By.xpath("//ol[@class='product-items widget-product-grid']"));
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        for(int i = 0; i < allProductItems.size(); i++){
            actions.moveToElement(allProductItems.get(i)).build().perform();
            Assert.assertTrue("Add to Cart button is NOT visible!", addToCartButton.isDisplayed());
        }

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
