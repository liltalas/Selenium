package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class BrowserNavigation extends CommonMethods {
    @Test
    public void learnBrowserNavigation() throws InterruptedException {
        WebDriver driver = getDriver();

        Thread.sleep(3000);

        //driver.navigate().to(url) essentially opens up a different url in the same driver session
        //It is the equivalent of using the search bar to go from the current website to a different one
        driver.navigate().to("http://18.116.88.132:8080/bank/login");

        Thread.sleep(3000);

        // will bring you to the original url you were before going into a new page/link
        driver.navigate().back();

        Thread.sleep(3000);

        // does the opposite of the .back() method, will essentially undo the method .back()
        driver.navigate().forward();

        Thread.sleep(3000);

        // will refresh the current page
        driver.navigate().refresh();

        Thread.sleep(3000);
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = getDriver();

        loginToSauceDemo();

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
