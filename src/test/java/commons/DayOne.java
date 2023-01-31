package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DayOne {

    private static WebDriver driver;
    public void createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
