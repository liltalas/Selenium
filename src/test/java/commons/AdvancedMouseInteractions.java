package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtils;

public class AdvancedMouseInteractions extends CommonMethods {

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException {
        WebDriver driver = getDriver();

        //Creating object of the actions class and passing webDriver as a particular to its constructor
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(), 'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(), 'Right')]"));

        // actions class has a lot of different methods to perform various different advanced mouse interactions and actions
        //Here, we r calling the .doubleClick() method and passing the element we want to double click on
        // then calling the .build() method to build the actual sequence
        // and then the .perform() method which actually performs the actions/executes
       // actions.doubleClick(doubleClickBtn).build().perform();

        // moves the "mouse" first and then performs the double click
        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
        Thread.sleep(4000);


        actions.contextClick(rightClickBtn).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        Thread.sleep(2000);

        WebElement hoverIcon = driver.findElement(By.xpath("//div[@class='figure'][1]"));

        //using the .moveToElement() method to essentially hover over a specific element
        actions.moveToElement(hoverIcon).build().perform();

        Thread.sleep(3000);

        WebElement viewProfileLink = driver.findElement(By.xpath("//div[@class='figure'][1]//a"));

        actions.keyDown(Keys.COMMAND).click(viewProfileLink).keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(3000);
    }


    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable'][1]"));

        //dragAndDrop(WebElement, WebElement) method will drag the first parameter passed to the location of second
        // parameter passed
        actions.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath(" //input[@type='range']"));

        //dragAndDropBy(WebElement, xOffset, yOffset) method will drag the element by the given x and y offset
        actions.dragAndDropBy(slider,50, 0).build().perform();
        actions.dragAndDropBy(slider,-50, 0).build().perform();

        Thread.sleep(3000);

    }


    @Test
    public void learnScroll() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        loginToSauceDemo();

        WebElement SauceLabsOnesie= driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));

        //scrollToElement() method will scroll to the WebElement passed as the parameter(scrolls very fast)
        //actions.scrollToElement(SauceLabsOnesie).build().perform();

        Thread.sleep(3000);

        // scroll by the specified mount on the x and y
        actions.scrollByAmount(0,500).build().perform();
        Thread.sleep(3000);
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
