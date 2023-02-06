package Assignment;

import utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 extends DriverUtils {

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com");
    }

    @Test
    public void login() throws InterruptedException {

        WebDriver driver = getDriver();

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        //Login
        userNameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        Thread.sleep(3000);

        // Now we are in the product page
        WebElement productPageTitle = driver.findElement(By.className("title"));
        Assert.assertTrue("Not on a product page", productPageTitle.isDisplayed());


        Thread.sleep(3000);

        //add the first item to the cart
        WebElement AddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddToCartButton.click();


        Thread.sleep(3000);



        // shopping cart
        WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));

        // Verify that the item you added is visible in the cart page
        WebElement InventoryItemName = driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        Assert.assertTrue("The item is not visible in the cart page", InventoryItemName.isDisplayed());
        ShoppingCart.click();

        Thread.sleep(3000);
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
