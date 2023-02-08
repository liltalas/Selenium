package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.DriverUtils;

import java.util.ArrayList;
import java.util.List;

// filter price low to high

public class Task4 extends DriverUtils {

    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com");
    }

    @Test
    public void useOptionValue() throws InterruptedException {

        WebDriver driver = getDriver();

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        //1. Login
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        Thread.sleep(5000);

        // Now we are in the product page
        WebElement productPageTitle = driver.findElement(By.className("title"));
        Assert.assertTrue("Not on a product page", productPageTitle.isDisplayed());

        Thread.sleep(3000);

        // 2. click on the filter and select Price(low to high)

        WebElement filter = driver.findElement(By.xpath("//select"));
        Select productSorting = new Select(filter);

        productSorting.selectByVisibleText("Price (low to high)");


        Thread.sleep(3000);

        //3. Assert that the span with active-option class value has changed to the option you selected
        WebElement lowToHigh = driver.findElement(By.xpath(" //option[@value='lohi']"));
        WebElement spanActiveOption = driver.findElement(By.xpath("//span[@class='active_option']"));
        Assert.assertTrue("not changed", lowToHigh.getText().equalsIgnoreCase(spanActiveOption.getText()));

        Thread.sleep(3000);

        // Advanced task -> Before refreshing the page ensure that the first item is indeed the cheapest one.
        List<WebElement> inventoryItemPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double>ItemPriceDouble = new ArrayList<>();


        // getting rid of the sign $ from all items using substring
        // converted string into double using Double.parseDouble

        for (int i = 0; i < inventoryItemPrice.size(); i++) {
            ItemPriceDouble.add(i, Double.parseDouble(inventoryItemPrice.get(i).getText().substring(1)));
        }

        // comparing the values to find out which one is the cheapest one.
        double lowestPrice = ItemPriceDouble.get(0);
        for(int i= 0; i< ItemPriceDouble.size(); i++) {
            if(ItemPriceDouble.get(i) < lowestPrice){
                lowestPrice = ItemPriceDouble.get(i);
            }

        }
        System.out.println(lowestPrice);
            //4. Now refresh the page and ensure that the filter changed back to its original state
            driver.navigate().refresh();

            Select select = new Select(driver.findElement(By.xpath("//select")));
            WebElement option = select.getFirstSelectedOption();
            String defaultItem = option.getText();
            System.out.println(defaultItem);

            Thread.sleep(3000);

            // Whenever you face this issue, just define the web element/object once again above the line in which you
            // are getting an Error.

        }


    @After
    public void cleanUp() {
        quitDriver();
    }

}


