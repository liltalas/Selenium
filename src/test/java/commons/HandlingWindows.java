package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods{

    @Test
    public void learnWindowHandling() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));

        // .getWindowHandle() returns the String window handle of the current window
        // we are creating the window handle of the current window as a String variable so that we can always return
        // and go back to it
        String primaryWindow = driver.getWindowHandle();


        tabButton.click();
        windowButton.click();

        Thread.sleep(3000);

        // taking the return type Set<String> and casting it to an ArrayList<String> for easy access
        Set<String> windowSet = driver.getWindowHandles();
        ArrayList<String>windowList = new ArrayList<>(windowSet);

        //creating for each loop to cycle through the elements of the window list and we are making sure
        // that the current window isn't the primary window we were originally in
        for(String window: windowList){
            if(!window.equals(primaryWindow)){
                Thread.sleep(3000);
                // switching to the current window that passed all above conditions
                driver.switchTo().window(window);
                WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                driver.close();
            }
        }
        driver.switchTo().window(primaryWindow);
        Thread.sleep(3000);

        // Selenium recognizes as the id of the window ---> [CDwindow-0F28EE368B6A0A5B8AFA998D7453B6CB
       // System.out.println(driver.getWindowHandles());
       // Thread.sleep(3000);
    }

    @Test
    public void windowHandlingExample() throws InterruptedException {
        WebDriver driver = getDriver();

        Actions actions = new Actions(driver);

        String primaryWindowSave = driver.getWindowHandle();

        WebElement shopNewYogaBtn = driver.findElement(By.xpath("//span[@class='action more button']"));

        // to open it in a new window
        actions.keyDown(Keys.COMMAND).click(shopNewYogaBtn).keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(3000);



        // .getWindowHandles() method returns  set of windowHandles we can pass it to the constructor
        // of the arraylist which will cst it nto n rryList
        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());

        for(String window: windowList){
            if(!window.equals(primaryWindowSave)){
                driver.switchTo().window(window);

                if(!driver.getCurrentUrl().contains("/collections/yoga-new.html")){
                    driver.close();

                }
            }
        }

        WebElement yogaCollections = driver.findElement(By.xpath("//li[@class='item category8']/strong"));
        System.out.println(yogaCollections.getText());
        Assert.assertTrue("not found the title", yogaCollections.isDisplayed());

        Thread.sleep(3000);
        // closing the current window
        driver.close();

        // switching to the original window
        driver.switchTo().window(primaryWindowSave);

        Assert.assertTrue("Shop New Yoga Button is not visible", shopNewYogaBtn.isDisplayed());

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
