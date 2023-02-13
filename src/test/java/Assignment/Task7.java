package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtils;

import java.util.ArrayList;

// The usage of Window Handling
public class Task7 extends DriverUtils {

    //1. open the website
    @Before
    public void setUp() {
        createDriver("https://magento.softwaretestingboard.com/");
    }


    @Test
    public void useHandlingWindows() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

    // 2. Command/Control click on the “Sale” option in the header
        String primaryWindowSave = driver.getWindowHandle();

        WebElement sale = driver.findElement(By.cssSelector("#ui-id-8"));
        actions.keyDown(Keys.COMMAND).click(sale).keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(5000);

    // 3. switchTo() the new opened tab (window)

        ArrayList<String> windowList= new ArrayList<>(driver.getWindowHandles());

        for(String window:windowList){
            if(!window.equalsIgnoreCase(primaryWindowSave)){
                // switching to the current window that passed all above conditions
                driver.switchTo().window(window);

                if(!driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sale.html")){
                    driver.close();
                }
            }

        }

        Thread.sleep(3000);

        // 4. Assert that all the promotion block are displayed

        WebElement womenDeals = driver.findElement(By.xpath("//div[@class='categories-menu']//span"));
        WebElement menDeals = driver.findElement(By.xpath("//div[@class='categories-menu']//following::span"));
        WebElement gearDeals = driver.findElement(By.xpath("//div[@class='categories-menu']//following::span[2]"));
        Assert.assertTrue("Women Deals Is Not Visible", womenDeals.isDisplayed());
        Assert.assertTrue("Men Deals Is Not Visible", menDeals.isDisplayed());
        Assert.assertTrue("Gear Deals Is Not Visible", gearDeals.isDisplayed());

        Thread.sleep(3000);

        //5. Close the tab and switch back to the primary tab
        driver.close();

        driver.switchTo().window(primaryWindowSave);

        // 6. Assert that you are back on the landing page
        WebElement welcomeMessage = driver.findElement(By.xpath("//span[text()='Default welcome msg!']"));
        Assert.assertTrue("Text Is NOT Visible!", welcomeMessage.isDisplayed());

        Thread.sleep(3000);
    }




    @After
    public void cleanUp(){
        quitDriver();
    }
}
