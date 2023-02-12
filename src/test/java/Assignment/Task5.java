package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.DriverUtils;

public class Task5 extends DriverUtils {

    // Advanced Mouse Interactions
    //email address:hihi@gmail.com - always must change before running the whole program
    //password:Abc#12345
    //Full name:ABC OS

    //1. Open the page:https://magento.softwaretestingboard.com/
    @Before
    public void setUp(){
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void magentoSoftwareTesting()throws InterruptedException{
        WebDriver driver=getDriver();
        Actions actions=new Actions(driver);

    //2. Once on the page scroll down to the bottom of the page where the “HotSellers” section is visible

        WebElement hotSellersTitle=driver.findElement(By.xpath("//h2[@class='title']"));
        actions.scrollToElement(hotSellersTitle).build().perform();

        Thread.sleep(3000);

    //3. Select an item and hover over it
    //4. While hovering assert that the add to cart button is visible then select the size and color

        WebElement bETankHoverOver=driver.findElement(By.xpath("//li[@class='product-item'][2]"));
        actions.scrollByAmount(0,700).moveToElement(bETankHoverOver).build().perform();

        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.xpath("//li[@class='product-item'][2]//button[@title='Add to Cart']"));
        Assert.assertTrue("Add to Cart button is not visible", addToCartButton.isDisplayed());

        Thread.sleep(3000);

        WebElement size = driver.findElement(By.xpath("//li[@class='product-item'][2]//div[contains(text(), 'XS')]"));
        WebElement color = driver.findElement(By.xpath("//li[@class='product-item'][2]//div[@id='option-label-color-93-item-59']"));

        actions.moveToElement(size).click(size).build().perform();
        actions.moveToElement(color).click(color).build().perform();

        Thread.sleep(3000);

    //5. Once item is added to cart page should reload

        actions.moveToElement(addToCartButton).click(addToCartButton).build().perform();

        Thread.sleep(3000);

    //6. After page has been reloaded you can proceed to check out. (Either through the cart icon or the cart page)

        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='action showcart']"));
        actions.moveToElement(cartIcon).click(cartIcon).build().perform();
        Thread.sleep(3000);

        WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
        actions.moveToElement(proceedToCheckoutBtn).click(proceedToCheckoutBtn).build().perform();
        Thread.sleep(3000);

    //7. Once on checkout page fill out the form USE FAKE INFO (Try to challenge yourself and use complex locators)
        WebElement emailAddress = driver.findElement(By.xpath("//div[@class='opc-wrapper']//input[@type='email']"));
        emailAddress.sendKeys("hihello@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#customer-password"));
        password.sendKeys("Abc#12345");
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Login']"));
        login.click();
        Thread.sleep(3000);

        WebElement streetAddress = driver.findElement(By.xpath("//input[@name='street[0]']"));
        streetAddress.sendKeys("Cute Cat Avenue 007");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("SF");
        Thread.sleep(1000);

        WebElement Dropdown = driver.findElement(By.xpath("//select[@name='region_id']"));
        Select stateDropdown = new Select(Dropdown);
        stateDropdown.selectByVisibleText("California");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipCode.sendKeys("12345");
        Thread.sleep(1000);

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country_id']"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        Thread.sleep(1000);

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='telephone']"));
        phoneNumber.sendKeys("800 678 3586");
        Thread.sleep(1000);

        WebElement shippingMethods = driver.findElement(By.xpath("//input[@value='tablerate_bestway']"));
        actions.moveToElement(shippingMethods).click().build().perform();
        Thread.sleep(1000);

        WebElement nextButton = driver.findElement(By.xpath("//button[@data-role='opc-continue']"));
        actions.moveToElement(nextButton).click().build().perform();
        Thread.sleep(4000);

    // 8. Once you reach Review & Payments assert that the info you entered is the info displayed
        WebElement billingInfo = driver.findElement(By.xpath("//div[@class='billing-address-details']"));

        System.out.println(billingInfo.getText());
        // avoided concatenation by using text block
        String expectedText = """
                ABC OS
                Cute Cat Avenue 007
                SF, California 12345
                United States
                800 678 3586""";

        Assert.assertEquals("Info Displayed Does Not Match", expectedText, billingInfo.getText());

        Thread.sleep(4000);

   // 9. Then hit place order and assert that your order has been placed by checking the success screen.

        WebElement placeOrder = driver.findElement(By.xpath("//button[@title='Place Order']"));
        actions.moveToElement(placeOrder).click().build().perform();
        Thread.sleep(5000);

        WebElement successPage = driver.findElement(By.xpath("//span[text()='Thank you for your purchase!']"));
        Assert.assertTrue("Could Not Find The Confirmation Page", successPage.isDisplayed());
        Thread.sleep(1000);
    }


    @After
    public void cleanUp(){
        quitDriver();
    }

}
