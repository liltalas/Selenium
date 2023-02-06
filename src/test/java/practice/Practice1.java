package practice;

import commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice1 extends CommonMethods {

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = getDriver();

        loginToSauceDemo();

        Thread.sleep(3000);

        // assert cart is displayed; click cart button
        WebElement Cart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
        Assert.assertTrue("Shopping Cart Is Not Visible", Cart.isDisplayed());
        Cart.click();

        Thread.sleep(3000);


        // assert checkout is displayed
        WebElement Checkout = driver.findElement((By.id("checkout")));
        Assert.assertTrue("Checkout Button Is Not Visible", Checkout.isDisplayed());

        Thread.sleep(3000);

        //go back to the product page
        driver.navigate().back();

        Thread.sleep(3000);

        // add item to cart
        WebElement AddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddToCartButton.click();

        Thread.sleep(3000);

        // go back to cart pages and assert the item is there
        driver.navigate().forward();

        WebElement VerifyInventoryItemIsVisible = driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        Assert.assertTrue("The item is not visible in the checkout", VerifyInventoryItemIsVisible.isDisplayed());
        System.out.println(VerifyInventoryItemIsVisible.getText());

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
